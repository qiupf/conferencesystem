package com.noerrorsnowarning.conferencesystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GuestConMapper {

    //根据会议id获取外宾信息
    @Select("select count(*) " +
            "from Guest g, guestConference gc " +
            "where gc.GID = g.GID " +
            "and gc.CID = #{CID}")
    int numByGuestCon(@Param("CID") int cid);

}