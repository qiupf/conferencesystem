package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.Room;
import org.apache.ibatis.annotations.*;
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
    List<Room> findRoomByIdOrAddress(@Param("roomID") String roomID,
                                     @Param("roomAddress") String roomAddress);

    @Select("select * from Room " +
            "where RoomID = #{roomID} ")
    Room findRoomById(@Param("roomID") String roomID);

    @Select("select r.* from " +
            "(select * from Room where Equip regexp #{equip}) r " +
            "where Rstarttime <= #{startTime} " +
            "and Rendtime >= #{endTime} " +
            "and Rcapacity >= #{num}")
    List<Room> findRoomByOhter(@Param("startTime") String startTime,
                               @Param("endTime") String endTime,
                               @Param("num") String num,
                               @Param("equip") String s);

    @Select("select Raddress from Room where RoomID = #{RoomID}")
    String findRaddressByRoomID(@Param("RoomID") String RoomID);

    @Insert("insert into room values (" +
            "#{id}, #{name}, #{num}, '08:00:00', '22:00:00', #{equip}, '')")
    int addRoom(@Param("id") String id,
                @Param("name") String name,
                @Param("num") int num,
                @Param("equip") String equip);

    @Update("update room set" +
            " Raddress=#{name}," +
            " Rcapacity=#{num}," +
            " Equip=#{equip}" +
            " where RoomID=#{id}")
    int modify(@Param("name") String name,
               @Param("num") int num,
               @Param("equip") String equip,
               @Param("id") String id);

    @Delete("delete from room where " +
            "RoomID=#{rid}")
    int remove(@Param("rid") String rid);


}