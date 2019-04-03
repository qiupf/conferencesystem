package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StaffMapper {

    //判断登录结果
    @Select("select count(*) from Staff where StaffID = #{StaffID} and Spassword = #{Spassword}")
    int queryStaffByIdAndPassword(@Param("StaffID") String id, @Param("Spassword") String password);

    //根据用户id获取用户信息
    @Select("select * from Staff where StaffID = #{StaffID}")
    Staff queryStaffById(@Param("StaffID") String id);

    @Update("update Staff set Smobilenum = #{num} where StaffID = #{ID}")
    int update(@Param("ID")String ID,@Param("num")String number);

}