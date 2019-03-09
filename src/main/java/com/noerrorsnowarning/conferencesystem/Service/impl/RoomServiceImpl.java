package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.RoomService;
import com.noerrorsnowarning.conferencesystem.dao.RoomMapper;
import com.noerrorsnowarning.conferencesystem.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomMapper roomMapper;

    @Autowired
    public RoomServiceImpl(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public int RoomInsert(Room room,String[] equip,int numEquip) {

        String s="";
        int n=0;
        for(int i=0;i<numEquip;++i) {
            if (n < equip.length && equip[n].charAt(0) - '1' == i) {
                s += "1";
                n++;
            } else {
                s += "0";
            }
        }

        room.setEquip(s);

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

        String s="";

        //通过正则表达式来判断设备
        if(equip==null||equip.length==0){
            s=".";
        }else {
            int n=0;
            for(int i=0;i<numEquip;++i) {
                if(n<equip.length) {
                    if (i == equip[n].charAt(0) - '1') {
                        s += "[^0]";
                        n++;
                    } else {
                        s += ".";
                    }
                }else {
                    s+=".";
                }
            }
        }

        List<Room>roomList=roomMapper.findRoomByOhter(startTime,endTime,num,s);
        return roomList;
    }

}