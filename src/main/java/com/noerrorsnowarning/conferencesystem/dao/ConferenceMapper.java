package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;
import com.noerrorsnowarning.conferencesystem.domain.Reserved;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ConferenceMapper {

    //根据用户id返回未参加的会议
    @Select("select c.ConferenceID, r.Raddress, c.RoomID, c.Cstarttime, c.Cstarttime as starttime, " +
            "c.Cendtime, c.RSID, c.Cname, c.Cnum, c.Signtime, cs.state " +
            "from Conference c, Room r, Staff s, ConferenceSign cs " +
            "where c.RoomID = r.RoomID " +
            "and cs.SID = #{SID}" +
            "and c.conferenceID = cs.CID " +
            "and c.Cstarttime > #{now} " +
            "and cs.SID = s.StaffID")
    List<ConferenceInfo> funConBySID(@Param("now") String now,@Param("SID")String sid);

    //根据用户名返回已经参加的会议
    @Select("select r.Raddress, r.RoomID, c.RoomID, c.Cstarttime, c.Cstarttime as starttime, " +
            "c.Cendtime, c.RSID, c.Cname, cs.state " +
            "from Conference c, Room r, Staff s, ConferenceSign cs " +
            "where c.RoomID = r.RoomID " +
            "and cs.SID = #{SID}  " +
            "and c.conferenceID = cs.CID " +
            "and c.Cstarttime < #{now} " +
            "and cs.SID = s.StaffID")
    List<ConferenceInfo> pastConBySID(@Param("now") String now,@Param("SID")String sid);

    @Insert("insert into " +
            "Conference(RoomID, RSID, Cstarttime, Cendtime, Cname, Cnum) " +
            "values " +
            "(#{RoomID}, #{RSID}, #{startString}, #{endString}, #{Cname}, #{Cnum})")
    @Options(useGeneratedKeys = true,keyProperty = "ConferenceID",keyColumn = "ConferenceID")
    int insertReserved(Reserved reserved);

}