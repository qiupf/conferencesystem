package com.noerrorsnowarning.conferencesystem.tools;

import com.noerrorsnowarning.conferencesystem.domain.Room;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.ParseException;

public class RoomGetParameter implements getParameter {

    private ConvertTime convertTime = new ConvertTime();

    @Override
    public Room getParameter(HttpServletRequest request) throws ParseException {

        //从前端获取数据
        String id = request.getParameter("meetingroom_ID");
        String capacity = request.getParameter("volume");
        String address = request.getParameter("address");
        String jurisdiction = request.getParameter("grade");
        String start = request.getParameter("available_time_start");
        String end = request.getParameter("available_time_end");
        String[] equip = request.getParameterValues("equip");

        //数据库内类型为int，要将String装为int
        if (jurisdiction == null) {
            jurisdiction = "1";
        }
        int intCapacity = Integer.valueOf(capacity);
        int intJurisdiction = Integer.valueOf(jurisdiction);

        //数据库内类型为Time，要将String转为Time
        Time startTime = null;
        Time endTime = null;
        if (start != null && !start.equals("")) {
            startTime = convertTime.stringToTime(start);
        }
        if (end != null && !start.equals("")) {
            endTime = convertTime.stringToTime(end);
        }

        //插入新会议室
        Room room = new Room(id, address, intCapacity, intJurisdiction, startTime, endTime);

        return room;
    }
}