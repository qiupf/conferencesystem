package com.noerrorsnowarning.conferencesystem.domain;

import java.sql.Date;
import java.sql.Time;

public class Reserved {

    private String RoomID;
    private int ConferenceID;
    private String Raddress;
    private int Rcapacity;
    private Date Cstarttime;
    private Time starttime;
    private Time Cendtime;
    private String equip;
    private String RSID;
    private String Cname;
    private int Cnum;
    private int numGuest;
    private Time Signtime;
    private String sign;
    private String startString;
    private String endString;
    private String url;
    private String Cstate;
    private String refuseurl;
    private String accepturl;

    public Reserved(){}

    public Reserved(String RoomID,String RSID,String startString,String endString,String Cname,int Cnum){
        this.RoomID=RoomID;
        this.RSID=RSID;
        this.startString=startString;
        this.endString=endString;
        this.Cname=Cname;
        this.Cnum=Cnum;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String roomID) {
        RoomID = roomID;
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

    public int getConferenceID() {
        return ConferenceID;
    }

    public void setConferenceID(int conferenceID) {
        ConferenceID = conferenceID;
    }

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public String getEndString() {
        return endString;
    }

    public void setEndString(String endString) {
        this.endString = endString;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCstate() {
        return Cstate;
    }

    public void setCstate(String cstate) {
        Cstate = cstate;
    }

    public String getRefuseurl() {
        return refuseurl;
    }

    public void setRefuseurl(String refuseurl) {
        this.refuseurl = refuseurl;
    }

    public String getAccepturl() {
        return accepturl;
    }

    public void setAccepturl(String accepturl) {
        this.accepturl = accepturl;
    }
}
