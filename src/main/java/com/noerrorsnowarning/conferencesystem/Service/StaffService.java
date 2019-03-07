package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.Staff;

public interface StaffService {

    Staff queryStaffById(String id);

    boolean login(String id, String password);

}
