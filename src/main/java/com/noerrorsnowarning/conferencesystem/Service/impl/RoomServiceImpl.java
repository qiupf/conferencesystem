package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.RoomService;
import com.noerrorsnowarning.conferencesystem.dao.RoomMapper;
import com.noerrorsnowarning.conferencesystem.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomMapper roomMapper;

    @Autowired
    public RoomServiceImpl(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public int RoomInsert(HttpServletRequest request, String[] equip, int numEquip) throws ParseException {

        //写了一个转换函数，不然getParameter太多很丑
        Room room = getParameter(request);

        //插入设备值
        StringBuilder s=new StringBuilder();
        int n=0;
        for(int i=0;i<numEquip;++i) {
            if (n < equip.length && equip[n].charAt(0) - '1' == i) {
                s.append("1");
                n++;
            } else {
                s.append("0");
            }
        }

        room.setEquip(s.toString());

        return roomMapper.add(room);
    }

    @Override
    public List<Room> getRoom() {
        return roomMapper.findRoom();
    }

    @Override
    public List<Room> findRoomByIdOrAddress(String id, String address) {

        //要用equals判断，不能用null来判断
        id=id.equals("")?"%":id;
        address=address.equals("")?"%":address;

        List<Room>roomList=roomMapper.findRoomByIdOrAddress(id,address);

        return roomList;
    }

    @Override
    public List<Room> findRoomEquipByOther(String startTime, String endTime, String num,String[] equip,int numEquip) {

        if(startTime.equals("")){
            startTime="24:00";
        }if(endTime.equals("")){
            endTime="00:00";
        }if(num.equals("")){
            num="0";
        }
        startTime=startTime+":00";
        endTime=endTime+":00";

        StringBuilder s=new StringBuilder();

        //通过正则表达式来判断设备
        if(equip==null||equip.length==0){
            s.append(".");
        }else {
            int n=0;
            for(int i=0;i<numEquip;++i) {
                if(n<equip.length) {
                    if (i == equip[n].charAt(0) - '1') {
                        s.append("[^0]");
                        n++;
                    } else {
                        s.append(".");
                    }
                }else {
                    s.append(".");
                }
            }
        }

        List<Room>roomList=roomMapper.findRoomByOhter(startTime,endTime,num,s.toString());
        return roomList;
    }

    private Room getParameter(HttpServletRequest request) throws ParseException {

        String id = request.getParameter("meetingroom_ID");
        String capacity = request.getParameter("volume");
        String address = request.getParameter("address");
        String jurisdiction = request.getParameter("grade");
        String start = request.getParameter("available_time_start");
        String end = request.getParameter("available_time_end");

        //数据库内类型为int，要将String装为int
        if (jurisdiction == null) {
            jurisdiction = "1";
        }
        int intCapacity = Integer.valueOf(capacity);
        int intJurisdiction = Integer.valueOf(jurisdiction);

        //数据库内类型为Time，要将String转为Time
        Time startTime = null;
        Time endTime = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        if (start != null && !start.equals("")) {
            java.util.Date date = simpleDateFormat.parse(start);
            startTime = new Time(date.getTime());
        }
        if (end != null && !start.equals("")) {
            java.util.Date date = simpleDateFormat.parse(end);
            endTime = new Time(date.getTime());
        }

        //插入新会议室
        Room room = new Room(id, address, intCapacity, startTime, endTime);

        return room;
    }

}