package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.MasterService;
import com.noerrorsnowarning.conferencesystem.dao.MasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {

    private MasterMapper masterMapper;

    @Autowired
    MasterServiceImpl(MasterMapper masterMapper) {
        this.masterMapper = masterMapper;
    }

    @Override
    public boolean findMaster(String id, String pwd) {
        boolean result = true;
        int login = masterMapper.findMaster(id, pwd);
        if (login != 1) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}