package com.noerrorsnowarning.conferencesystem.domain;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class Room {

    private String RoomID;
    private String Raddress;
    private Integer Rcapacity;
    private Time Rstarttime;
    private Time Rendtime;
    private String Equip;
    private String equips;

    public Room(String RoomID, String Raddress, Integer Rcapacity, Time Rstarttime, Time Rendtime){

        this.RoomID=RoomID;
        this.Raddress=Raddress;
        this.Rcapacity=Rcapacity;
        this.Rstarttime=Rstarttime;
        this.Rendtime=Rendtime;

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

    public Integer getRcapacity() {
        return Rcapacity;
    }

    public void setRcapacity(Integer rcapacity) {
        Rcapacity = rcapacity;
    }

    public Time getRstarttime() {
        return Rstarttime;
    }

    public void setRstarttime(Time rstarttime) {
        Rstarttime = rstarttime;
    }

    public Time getRendtime() {
        return Rendtime;
    }

    public void setRendtime(Time rendtime) {
        Rendtime = rendtime;
    }

    public String getEquip() {
        return Equip;
    }

    public void setEquip(String equip) {
        Equip = equip;
    }

    public String getEquips() {
        return equips;
    }

    public void setEquips(String equips) {
        this.equips = equips;
    }
}
