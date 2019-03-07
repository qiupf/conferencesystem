package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.Room;

import java.util.List;

public interface RoomService {

    int RoomInsert(Room room,String[] equip,int numEquip);

    List<Room> getRoom();

    List<Room> findRoomByIdOrAddress(String id, String address);

    List<Room> findRoomEquipByOther(String startTime, String endTime, String num,String[] equip,int numEquip);

}