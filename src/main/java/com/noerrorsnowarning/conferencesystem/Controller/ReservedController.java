package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.ReservedService;
import com.noerrorsnowarning.conferencesystem.domain.Reserved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class ReservedController {

    private ReservedService reservedService;

    @Autowired
    ReservedController(ReservedService reservedService) {
        this.reservedService = reservedService;
    }

    @RequestMapping(value = "/html/mymeeting1.html", method = RequestMethod.GET)
    public String mymeetingHtml(Model model, HttpServletRequest request) {

        String id = (String) request.getSession().getAttribute("Sname");

        //返回已预定会议室
        List<Reserved> meetingList = reservedService.getReserved(id);

        model.addAttribute("meetingList", meetingList);

        return "html/mymeeting1";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, HttpServletRequest request) {

        int result = reservedService.updateReserved(request);

        String url = mymeetingHtml(model, request);

        return url;
    }

}