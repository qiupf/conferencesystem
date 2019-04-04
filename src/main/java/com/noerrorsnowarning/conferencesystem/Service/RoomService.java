package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.Room;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface RoomService {

    int RoomInsert(HttpServletRequest request, String[] equip, int numEquip) throws ParseException;

    List<Room> getRoom();

    List<Room> findRoomByIdOrAddress(String id, String address);

    List<Room> findRoomEquipByOther(String startTime, String endTime, String num,String[] equip,int numEquip);

    int addRoom(String id,String name,String num,String equip);

}