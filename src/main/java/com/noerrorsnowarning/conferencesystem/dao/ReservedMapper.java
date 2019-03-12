package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.Reserved;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReservedMapper {

    @Select("select r.RoomID,c.ConferenceID, r.Raddress, r.Rcapacity, " +
            "c.Cstarttime, c.Cstarttime as starttime, c.Cendtime, " +
            "c.RSID, c.Cname, c.MSID, c.Cnum, c.Signtime " +
            "from Room r,Conference c " +
            "where c.RSID like #{staffID} " +
            "and c.Cstarttime > #{now} " +
            "and r.RoomID = c.RoomID")
    List<Reserved> getReserved(@Param("staffID") String staffID, @Param("now") String now);

    @Insert("insert into " +
            "Conference(RoomID, RSID, Cstarttime) " +
            "values " +
            "(#{RoomID},#{RSID},#{dateString})")
    @Options(useGeneratedKeys = true,keyProperty = "ConferenceID",keyColumn = "ConferenceID")
    int insertReserved(Reserved reserved);

    @Update("update Conference " +
            "set " +
            "Cname = #{name}, " +
//            "MSID = #{MSID}, " +      //主会人因为外键，所以不能为空更新
            "Cstarttime = #{startTime}, " +
            "CendTime = #{endTime}, " +
            "Signtime = #{signTime} " +
            "where " +
            "ConferenceID = #{conferenceID}")
    int update(@Param("conferenceID")String conferenceID,
               @Param("name")String name,
               @Param("MSID")String MSID,
               @Param("startTime")String startTime,
               @Param("endTime")String endTime,
               @Param("signTime")String signTime);

}
