package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.MasterService;
import com.noerrorsnowarning.conferencesystem.interceptor.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/")
public class AdminLoginController {

    private MasterService masterService;

    @Autowired
    AdminLoginController(MasterService masterService) {
        this.masterService = masterService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/admin/login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginindex() {
        return "/admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) {

        String result;

        //从前端获取userName和password
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");

        //判断是否登录成功
        boolean login = masterService.findMaster(name, pwd);

        if (!login) {
            model.addAttribute("error", "用户名密码错误");
            result = "/admin/login";
        } else {

            //创建session
            HttpSession session = request.getSession();
            session.setAttribute("Sname", name);
            model.addAttribute("userName", name);
            result = "redirect:/admin/index.html";
        }
        return result;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    @Access(auths = {"admin"})
    public String index() {
        return "/admin/index.html";
    }

}