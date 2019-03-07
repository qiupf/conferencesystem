package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import com.noerrorsnowarning.conferencesystem.domain.Room;

import java.util.List;

public interface RoomAndEquipService {

    List<Room>roomAndEquip(List<Room>rooms, List<Equipment>equipmentList);

}
