package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.Reserved;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReservedService {

    List<Reserved>getReserved(String id);

    int insertReserved(String conferenID,String roomId,String user);

    int updateReserved(HttpServletRequest request);

}
