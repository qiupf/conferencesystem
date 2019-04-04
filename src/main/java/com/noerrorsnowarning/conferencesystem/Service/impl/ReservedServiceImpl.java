package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.ReservedService;
import com.noerrorsnowarning.conferencesystem.dao.ReservedMapper;
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

        //设置时间格式
//        SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String now = nowtime.format(new Date());
//
//        //判断是否是admin查询，admin查询查询所有
//        if (id.equals("admin")) {
//            id = "%";
//        }

        List<Reserved> reservedList = reservedMapper.getReserved(id);

        return reservedList;
    }

    @Override
    public List<Reserved> getAll() {
        return reservedMapper.getAll();
    }

//    @Override
//    public int insertReserved(String roomId, String user) {
//
//        //默认开会时间是当前时间+1天
//        Date date = new Date();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        calendar.add(calendar.DATE, 1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
//        date = calendar.getTime();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(date);
//
//        //新建domain对象
//        Reserved reserved = new Reserved(roomId, user, dateString);
//
//        int result = reservedMapper.insertReserved(reserved);
//
//        return result;
//    }

    @Override
    public int updateReserved(HttpServletRequest request) {

        String conferenceID = request.getParameter("conferenceID");
        String name = request.getParameter("Cname");
        String MSID = request.getParameter("MSID");
        String startTime = request.getParameter("Cstarttime");
        String endTime = request.getParameter("Cendtime");
        String signTime = request.getParameter("Signtime");
        String start = request.getParameter("start");

        //String对象是不可修改的，+运算会新建对象
        StringBuilder temp = new StringBuilder(20);
        temp.append(start);
        temp.append(" ");
        startTime = temp.append(startTime).toString();
        temp.delete(11, 19);
        endTime = temp.append(endTime).toString();
        temp.delete(11, 19);
        signTime = temp.append(signTime).toString();


        int result = reservedMapper.update(conferenceID, name, startTime, endTime, signTime);

        return result;
    }

    @Override
    public int delete(String id) {
        return reservedMapper.delete(id);
    }

}