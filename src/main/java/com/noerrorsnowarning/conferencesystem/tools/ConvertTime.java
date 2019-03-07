package com.noerrorsnowarning.conferencesystem.tools;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertTime {

    public Time stringToTime(String s) throws ParseException {

        //时间转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        java.util.Date date = simpleDateFormat.parse(s);
        return new Time(date.getTime());
    }
}
