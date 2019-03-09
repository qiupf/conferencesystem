package com.noerrorsnowarning.conferencesystem.domain;

import java.sql.Date;
import java.sql.Time;

public class Reserved {

    private String RoomID;
    private int ConferenID;
    private String Raddress;
    private int Rcapacity;
    private Date Cstarttime;
    private Time starttime;
    private Time Cendtime;
    private String equip;
    private String RSID;
    private String Cname;
    private String MSID;
    private int Cnum;
    private int numGuest;
    private Time Signtime;
    private String sign;
    private String dateString;

    public Reserved(String roomID,String RSID,String dateString){
        this.RoomID=roomID;
        this.RSID=RSID;
        this.dateString=dateString;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String roomID) {
        RoomID = roomID;
    }

    public int getConferenID() {
        return ConferenID;
    }

    public void setConferenID(int conferenID) {
        ConferenID = conferenID;
    }

    public String getRaddress() {
        return Raddress;
    }

    public void setRaddress(String raddress) {
        Raddress = raddress;
    }

    public int getRcapacity() {
        return Rcapacity;
    }

    public void setRcapacity(int rcapacity) {
        Rcapacity = rcapacity;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Date getCstarttime() {
        return Cstarttime;
    }

    public void setCstarttime(Date cstarttime) {
        Cstarttime = cstarttime;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public Time getCendtime() {
        return Cendtime;
    }

    public void setCendtime(Time cendtime) {
        Cendtime = cendtime;
    }

    public String getRSID() {
        return RSID;
    }

    public void setRSID(String RSID) {
        this.RSID = RSID;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getMSID() {
        return MSID;
    }

    public void setMSID(String MSID) {
        this.MSID = MSID;
    }

    public int getCnum() {
        return Cnum;
    }

    public void setCnum(int cnum) {
        Cnum = cnum;
    }

    public int getNumGuest() {
        return numGuest;
    }

    public void setNumGuest(int numGuest) {
        this.numGuest = numGuest;
    }

    public Time getSigntime() {
        return Signtime;
    }

    public void setSigntime(Time signtime) {
        Signtime = signtime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
