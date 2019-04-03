package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.Staff;

import javax.servlet.http.HttpServletRequest;

public interface StaffService {

    Staff queryStaffById(String id);

    boolean login(String id, String password);

    int update(HttpServletRequest request);

}
