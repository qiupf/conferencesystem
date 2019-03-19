package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoomMapper {

    //插入会议室
    @Insert("insert into " +
            "Room(RoomID, Raddress, Rcapacity, Rjurisdiction, Rstarttime, Rendtime, Equip) " +
            "values " +
            "(#{RoomID},#{Raddress},#{Rcapacity},#{Rjurisdiction},#{Rstarttime},#{Rendtime},#{Equip})")
    int add(Room room);

    //根据会议室id获取会议室
    @Select("select * from Room order by RoomID")
    List<Room> findRoom();

    //根据会议室id和address获取会议室
    @Select("select * from Room " +
            "where RoomID like #{roomID} and Raddress like #{roomAddress} " +
            "order by RoomID")
    List<Room>findRoomByIdOrAddress(@Param("roomID")String roomID,
                                    @Param("roomAddress")String roomAddress);

    @Select("select r.* from " +
            "(select * from Room where Equip regexp #{equip}) r " +
            "where Rstarttime <= #{startTime} " +
            "and Rendtime >= #{endTime} " +
            "and Rcapacity >= #{num}")
    List<Room>findRoomByOhter(@Param("startTime")String startTime,
                              @Param("endTime")String endTime,
                              @Param("num")String num,
                              @Param("equip")String s);

    @Select("select Raddress from Room where RoomID = #{RoomID}")
    String findRaddressByRoomID(@Param("RoomID")String RoomID);

}