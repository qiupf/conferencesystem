package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.GuestService;
import com.noerrorsnowarning.conferencesystem.dao.GuestMapper;
import com.noerrorsnowarning.conferencesystem.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    private GuestMapper guestMapper;

    @Autowired
    GuestServiceImpl(GuestMapper guestMapper) {
        this.guestMapper = guestMapper;
    }

    @Override
    public int addGuest(String name, String identity) {

        Guest guest = new Guest(name, identity);

        return guestMapper.addGuest(guest);
    }
}