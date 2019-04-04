package com.noerrorsnowarning.conferencesystem.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        String user = (String) request.getSession().getAttribute("Sname");
        String admin = (String) request.getSession().getAttribute("Sname");
        String url = request.getRequestURI();
        String[] array = url.split("/");
        if ((array.length > 1) && (array[1].equals("admin"))) {
            if (admin == null) {
                response.sendRedirect("/admin/login/");
                flag = false;
            }
        } else if (user == null) {
            response.sendRedirect("/login/");
            flag = false;
        }
        return flag;

        /*if (session == null) {


            //根据url来判断登录是admin还是普通用户
            if ((array.length > 1) && (array[1].equals("admin"))) {
                response.sendRedirect("/admin/login/");
            } else {
                response.sendRedirect("/login/");
            }
            flag = false;
        }
        return flag;*/
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}