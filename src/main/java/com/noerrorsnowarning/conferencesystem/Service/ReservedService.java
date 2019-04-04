package com.noerrorsnowarning.conferencesystem.Service;

import com.noerrorsnowarning.conferencesystem.domain.Reserved;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReservedService {

    List<Reserved>getReserved(String id);

    List<Reserved>getAll();

    int updateReserved(HttpServletRequest request);

    int delete(String id);

}
