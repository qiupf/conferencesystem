package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ConferenceMapper {

    //根据用户id返回未参加的会议
    @Select("select c.ConferenID, r.Raddress, c.Cstarttime, c.Cstarttime as starttime, " +
            "c.Cendtime, c.RSID, c.Cname, c.Cnum, c.Signtime, cs.state " +
            "from Conference c, Room r, Staff s, ConferenceSign cs " +
            "where c.RoomID = r.RoomID " +
            "and cs.SID = #{SID}" +
            "and c.conferenID = cs.CID " +
            "and c.Cstarttime > #{now}")
    List<ConferenceInfo> funConBySID(@Param("now") String now,@Param("SID")String sid);

    //根据用户名返回已经参加的会议
    @Select("select c.ConferenID, r.Raddress, c.Cstarttime, c.Cstarttime as starttime, " +
            "c.Cendtime, c.RSID, c.Cname, c.Cnum, c.Signtime, cs.state " +
            "from Conference c, Room r, Staff s, ConferenceSign cs " +
            "where c.RoomID = r.RoomID " +
            "and cs.SID = #{SID} " +
            "and c.conferenID = cs.CID " +
            "and c.Cstarttime < #{now}")
    List<ConferenceInfo> pastConBySID(@Param("now") String now,@Param("SID")String sid);

}