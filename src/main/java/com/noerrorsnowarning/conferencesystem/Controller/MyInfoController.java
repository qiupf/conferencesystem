package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.StaffService;
import com.noerrorsnowarning.conferencesystem.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MyInfoController {

    private StaffService staffService;

    @Autowired
    public MyInfoController(StaffService staffService){
        this.staffService=staffService;
    }

    @RequestMapping(value = "/html/myinfo.html", method = RequestMethod.GET)
    public String myinfo(HttpServletRequest request, Model model) {

        //根据session获取用户id，并获取其信息
        String id = (String) request.getSession().getAttribute("Sname");
        Staff staff = staffService.queryStaffById(id);
        model.addAttribute("info", staff);
        return "html/myinfo";
    }

    @RequestMapping(value = "/updateMobilePhone",method = RequestMethod.POST)
    public String update(HttpServletRequest request, Model model){

        staffService.update(request);
        return myinfo(request,model);
    }

}
