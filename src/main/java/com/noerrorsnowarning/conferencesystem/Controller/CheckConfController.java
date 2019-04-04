package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.MasterService;
import com.noerrorsnowarning.conferencesystem.Service.ReservedService;
import com.noerrorsnowarning.conferencesystem.domain.Reserved;
import com.noerrorsnowarning.conferencesystem.interceptor.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class CheckConfController {

    private MasterService masterService;
    private ReservedService reservedService;

    @Autowired
    CheckConfController(MasterService masterService, ReservedService reservedService) {
        this.masterService = masterService;
        this.reservedService = reservedService;
    }


    @RequestMapping(value = "/html/refuse", method = RequestMethod.GET)
    @Access(auths = {"admin"})
    public String refuse(Model model, HttpServletRequest request) {
        String meetingID = request.getParameter("meetingID");
        reservedService.refuse(meetingID);
        List<Reserved> allMeetinfList = reservedService.getAll();
        for (int i = 0; i < allMeetinfList.size(); ++i) {
            System.out.println(allMeetinfList.get(i).getConferenceID());
            allMeetinfList.get(i).setRefuseurl("refuse?meetingID=" + allMeetinfList.get(i).getConferenceID());
            allMeetinfList.get(i).setAccepturl("accept?meetingID=" + allMeetinfList.get(i).getConferenceID());
        }
        model.addAttribute("allMeetingList", allMeetinfList);
        return "redirect:/html/acheckconf.html";
    }

    @RequestMapping(value = "/html/accept", method = RequestMethod.GET)
    @Access(auths = {"admin"})
    public String accept(Model model, HttpServletRequest request) {
        String meetingID = request.getParameter("meetingID");
        reservedService.accept(meetingID);
        List<Reserved> allMeetinfList = reservedService.getAll();
        for (int i = 0; i < allMeetinfList.size(); ++i) {
            System.out.println(allMeetinfList.get(i).getConferenceID());
            allMeetinfList.get(i).setRefuseurl("refuse?meetingID=" + allMeetinfList.get(i).getConferenceID());
            allMeetinfList.get(i).setAccepturl("accept?meetingID=" + allMeetinfList.get(i).getConferenceID());
        }
        model.addAttribute("allMeetingList", allMeetinfList);
        return "redirect:/html/acheckconf.html";
    }


}
