package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ConferenceService {

    List<ConferenceInfo> searchCon(int choose,String user);

    ConferenceInfo getCon(String roomID,String user);

    int insertConference(HttpServletRequest request);
}