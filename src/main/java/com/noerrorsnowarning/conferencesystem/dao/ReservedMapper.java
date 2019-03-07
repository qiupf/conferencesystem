package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.Reserved;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReservedMapper {

    @Select("select r.RoomID,c.ConferenID, r.Raddress, r.Rcapacity, " +
            "c.Cstarttime, c.Cstarttime as starttime, c.Cendtime, " +
            "c.RSID, c.Cname, c.MSID, c.Cnum, c.Signtime " +
            "from Room r,Conference c,Staff s " +
            "where c.RSID like #{staffID} " +
            "and c.Cstarttime > #{now} " +
            "and r.RoomID = c.RoomID")
    List<Reserved> getReserved(@Param("staffID") String staffID, @Param("now") String now);

    @Insert("insert into " +
            "Conference(ConferenID, RoomID, RSID, Cstarttime) " +
            "values " +
            "(#{ConferenID},#{RoomID},#{RSID},#{Cstarttime})")
    int insertReserved(@Param("ConferenID")String ConferenID,
                       @Param("RoomID")String roomId,
                       @Param("RSID")String user,
                       @Param("Cstarttime")String time);

    @Update("update Conference " +
            "set " +
            "Cname = #{name}, " +
            "RSID = #{RSID}, " +
            "Cstarttime = #{startTime}, " +
            "CendTime = #{endTime}, " +
            "Signtime = #{signTime} " +
            "where " +
            "ConferenID = #{conferenceID}")
    int update(@Param("conferenceID")String conferenceID,
               @Param("name")String name,
               @Param("RSID")String RSID,
               @Param("startTime")String startTime,
               @Param("endTime")String endTime,
               @Param("signTime")String signTime);

}
