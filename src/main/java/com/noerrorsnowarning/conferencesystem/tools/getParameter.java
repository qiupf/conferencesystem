package com.noerrorsnowarning.conferencesystem.tools;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public interface getParameter {

    Object getParameter(HttpServletRequest request) throws ParseException;

}
