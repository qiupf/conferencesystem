package com.noerrorsnowarning.conferencesystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MasterMapper {

    //登录判断
    @Select("select count(*) from Master where Mid = #{id} and Mpassword = #{password}")
    int findMaster(@Param("id") String id, @Param("password") String password);

}