package com.noerrorsnowarning.conferencesystem.dao;

import com.noerrorsnowarning.conferencesystem.domain.Guest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GuestMapper {

    //@Options可以根据主键自增，自动设置id
    //插入外宾信息
    @Insert("insert into Guest(Gname,Gidentity) values (#{Gname},#{Gidentity})")
    @Options(useGeneratedKeys = true,keyProperty = "GID",keyColumn = "GID")
    int addGuest(Guest guest);

}