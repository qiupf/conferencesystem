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
            "c.RSID, c.Cname, c.Cnum, c.Signtime, c.Cstate " +
            "from Room r,Conference c " +
            "where c.RSID = #{staffID} " +
            "and r.RoomID = c.RoomID")
    List<Reserved> getReserved(@Param("staffID") String staffID);

    @Select("select r.RoomID,c.ConferenceID, r.Raddress, r.Rcapacity, " +
            "c.Cstarttime, c.Cstarttime as starttime, c.Cendtime, " +
            "c.RSID, c.Cname, c.Cnum, c.Signtime, c.Cstate " +
            "from Room r,Conference c " +
            "where r.RoomID = c.RoomID ")
    List<Reserved> getAll();

    @Update("update Conference " +
            "set " +
            "Cname = #{name}, " +
            "Cstarttime = #{startTime}, " +
            "CendTime = #{endTime}, " +
            "Signtime = #{signTime} " +
            "where " +
            "ConferenceID = #{conferenceID}")
    int update(@Param("conferenceID") String conferenceID,
               @Param("name") String name,
               @Param("startTime") String startTime,
               @Param("endTime") String endTime,
               @Param("signTime") String signTime);

    @Delete("delete from conference " +
            "where " +
            "ConferenceID = #{conferenceID}")
    int delete(@Param("conferenceID") String conferenceID);

    @Update("update Conference " +
            "set " +
            "Cstate = '失败' " +
            "where " +
            "ConferenceID = #{conferenceID}")
    int refuse(@Param("conferenceID") String conferenceID);

    @Update("update Conference " +
            "set " +
            "Cstate = '成功'  " +
            "where " +
            "ConferenceID = #{conferenceID}")
    int accept(@Param("conferenceID") String conferenceID);
}
