package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.ReservedService;
import com.noerrorsnowarning.conferencesystem.dao.ReservedMapper;
import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;
import com.noerrorsnowarning.conferencesystem.domain.Reserved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ReservedServiceImpl implements ReservedService {

    private ReservedMapper reservedMapper;

    @Autowired
    public ReservedServiceImpl(ReservedMapper reservedMapper) {
        this.reservedMapper = reservedMapper;
    }

    @Override
    public List<Reserved> getReserved(String id) {

        SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = nowtime.format(new Date());

        if(id.equals("admin")){
            id="%";
        }

        List<Reserved> reservedList = reservedMapper.getReserved(id, now);

        return reservedList;
    }

    @Override
    public int insertReserved(String roomId, String user) {

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        Reserved reserved=new Reserved(roomId,user,dateString);

        int result = reservedMapper.insertReserved(reserved);

        return result;
    }

    @Override
    public int updateReserved(HttpServletRequest request) {

        String conferenceID = request.getParameter("conferenceID");
        String name = request.getParameter("Cname");
        String MSID = request.getParameter("MSID");
        String startTime = request.getParameter("Cstarttime");
        String endTime = request.getParameter("Cendtime");
        String signTime = request.getParameter("Signtime");
        String start = request.getParameter("start");

        startTime = start + " " + startTime;
        endTime = start + " " + endTime;
        signTime = start + " " + signTime;

        int result = reservedMapper.update(conferenceID, name, MSID, startTime, endTime, signTime);

        return result;
    }
}