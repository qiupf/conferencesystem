package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.GuestService;
import com.noerrorsnowarning.conferencesystem.interceptor.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
@RequestMapping("/")
public class AddGuestController {

    private GuestService guestService;

    @Autowired
    AddGuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    //@Access是拦截器权限设置
    @RequestMapping(value = "/addGuest", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    public String addGuest(HttpServletRequest request, Model model) {

        //获取数据
        String name = request.getParameter("name");
        String identity = request.getParameter("identity");

        //返回添加是否成功
        int result = guestService.addGuest(name, identity);

        if (result == 1) {
            model.addAttribute("message", "插入成功");
        } else {
            model.addAttribute("message", "插入失败");
        }

        return "html/addguest.html";
    }

    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    public String add2(HttpServletRequest request, Model model) {

        return "redirect:/html/addstaffcontent.html";
    }

    @RequestMapping(value = "/html/addstaffcontent.html",method = RequestMethod.GET)
    public String bb(){
        return "html/addstaffcontent.html";
    }

}