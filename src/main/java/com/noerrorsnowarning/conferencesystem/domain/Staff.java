package com.noerrorsnowarning.conferencesystem.domain;

public class Staff {

    private String StaffID;
    private String Spassword;
    private String Sname;
    private String Ssex;
    private int Sage;
    private String mobilenum;
    private String Sdept;
    private String Spost;
    private int Sjurisdiction;
    private String faceFeature;

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        StaffID = staffID;
    }

    public String getSpassword() {
        return Spassword;
    }

    public void setSpassword(String spassword) {
        Spassword = spassword;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public String getSpost() {
        return Spost;
    }

    public void setSpost(String spost) {
        Spost = spost;
    }

    public int getSjurisdiction() {
        return Sjurisdiction;
    }

    public void setSjurisdiction(int sjurisdiction) {
        Sjurisdiction = sjurisdiction;
    }

    public String getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(String faceFeature) {
        this.faceFeature = faceFeature;
    }
}

