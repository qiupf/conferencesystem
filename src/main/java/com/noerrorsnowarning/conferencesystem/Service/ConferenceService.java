package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;

import java.util.List;

public interface ConferenceService {

    List<ConferenceInfo> searchCon(int choose,String user);

}