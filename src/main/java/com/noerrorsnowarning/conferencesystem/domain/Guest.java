package com.noerrorsnowarning.conferencesystem.domain;

public class Guest {

    private int GID;
    private String Gname;
    private String Gidentity;

    public Guest(int GID, String Gname, String Gidentity){
        this.GID=GID;
        this.Gname = Gname;
        this.Gidentity = Gidentity;
    }

    public int getGID() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID = GID;
    }

    public String getGname() {
        return Gname;
    }

    public void setGname(String gname) {
        Gname = gname;
    }

    public String getGidentity() {
        return Gidentity;
    }

    public void setGidentity(String gidentity) {
        Gidentity = gidentity;
    }
}
