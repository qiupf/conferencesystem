package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
@RequestMapping("/")
public class LoginController {

    private StaffService staffService;

    @Autowired
    public LoginController(StaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) {

        String result;

        //从前端获取userName和password
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");

        //判断是否登录成功
        boolean login = staffService.login(name, pwd);

        if (!login) {
            model.addAttribute("error", "用户名密码错误");
            result = "login";
        } else {

            //设置session
            HttpSession session = request.getSession();
            session.setAttribute("Sname", name);
            model.addAttribute("userName", name);
            result = "redirect:/index.html";
        }
        return result;
    }

    //区分get和post请求
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "exit",method = RequestMethod.GET)
    public String exit(HttpServletRequest request){
       /* Enumeration<String>enumeration=request.getSession().getAttributeNames();
        while(enumeration.hasMoreElements()){
            request.getSession().removeAttribute(enumeration.nextElement());
        }*/
        String name= (String) request.getSession().getAttribute("Sname");
        if(name!=null){
            request.getSession().removeAttribute("Sname");
        }
        return "login";
    }

}