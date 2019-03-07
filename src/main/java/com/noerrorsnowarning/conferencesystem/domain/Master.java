package com.noerrorsnowarning.conferencesystem.domain;

public class Master {

    private String Mid;
    private String Mname;
    private String Mpassword;
    private int Mpower;

    public String getMid() {
        return Mid;
    }

    public void setMid(String mid) {
        Mid = mid;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public int getMpower() {
        return Mpower;
    }

    public void setMpower(int mpower) {
        Mpower = mpower;
    }

    public String getMpassword() {
        return Mpassword;
    }

    public void setMpassword(String mpassword) {
        Mpassword = mpassword;
    }
}
