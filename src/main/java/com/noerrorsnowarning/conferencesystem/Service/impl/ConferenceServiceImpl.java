package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.ConferenceService;
import com.noerrorsnowarning.conferencesystem.dao.ConferenceMapper;
import com.noerrorsnowarning.conferencesystem.dao.GuestConMapper;
import com.noerrorsnowarning.conferencesystem.dao.RoomMapper;
import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private ConferenceMapper conferenceMapper;
    private GuestConMapper guestConMapper;
    private RoomMapper roomMapper;

    @Autowired
    public ConferenceServiceImpl(ConferenceMapper conferenceMapper, GuestConMapper guestConMapper, RoomMapper roomMapper) {
        this.conferenceMapper = conferenceMapper;
        this.guestConMapper = guestConMapper;
        this.roomMapper = roomMapper;
    }

    @Override
    public List<ConferenceInfo> searchCon(int choose, String user) {

        //获取当前时间并转换格式
        SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = nowtime.format(new Date());

        List<ConferenceInfo> conferenceList;

        //根据选择查看历史和将有的会议记录
        if (choose == 2) {
            conferenceList = conferenceMapper.funConBySID(time, user);
        } else if (choose == 3) {
            conferenceList = conferenceMapper.pastConBySID(time, user);
        } else {
            conferenceList = conferenceMapper.funConBySID(time, user);
            conferenceList.addAll(conferenceMapper.pastConBySID(time, user));
        }

        for (int i = 0; i < conferenceList.size(); ++i) {
            ConferenceInfo info = conferenceList.get(i);

            //获取外宾数量
            info.setNumGuest(guestConMapper.numByGuestCon(info.getConferenceID()));

            //根据是否有签到时间获取是否签到
            info.setSign(info.getSigntime() == null ? "否" : "是");
        }

        return conferenceList;
    }

    @Override
    public ConferenceInfo getCon(String roomID,String user) {
        String address=roomMapper.findRaddressByRoomID(roomID);
        String MSID=user;
        ConferenceInfo conferenceInfo=new ConferenceInfo(address,MSID);
        return conferenceInfo;
    }

}
