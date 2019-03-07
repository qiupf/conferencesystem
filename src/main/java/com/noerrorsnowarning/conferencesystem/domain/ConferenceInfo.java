package com.noerrorsnowarning.conferencesystem.domain;

import java.sql.Date;
import java.sql.Time;

public class ConferenceInfo {

    private int ConferenID;
    private String Raddress;
    private Date Cstarttime;
    private Time starttime;
    private Time Cendtime;
    private String RSID;
    private String Cname;
    private int Cnum;
    private Time Signtime;
    private String state;
    private int numGuest;
    private String sign;

    public int getConferenID() {
        return ConferenID;
    }

    public void setConferenID(int conferenID) {
        ConferenID = conferenID;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getRSID() {
        return RSID;
    }

    public void setRSID(String RSID) {
        this.RSID = RSID;
    }

    public void setCnum(int cnum) {
        Cnum = cnum;
    }

    public Date getCstarttime() {
        return Cstarttime;
    }

    public void setCstarttime(Date cstarttime) {
        Cstarttime = cstarttime;
    }

    public String getRaddress() {
        return Raddress;
    }

    public void setRaddress(String raddress) {
        Raddress = raddress;
    }

    public int getCnum() {
        return Cnum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Time getCendtime() {
        return Cendtime;
    }

    public void setCendtime(Time cendtime) {
        Cendtime = cendtime;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getSigntime() {
        return Signtime;
    }

    public void setSigntime(Time signtime) {
        Signtime = signtime;
    }

    public int getNumGuest() {
        return numGuest;
    }

    public void setNumGuest(int numGuest) {
        this.numGuest = numGuest;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
