package com.noerrorsnowarning.conferencesystem.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {

            //获取权限列表
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Access access = method.getAnnotation(Access.class);

            if (access == null) {
                return true;
            }

            //如果权限列表不为空，根据session查看是否有权限
            if (access.auths().length > 0) {
                String[] auths = access.auths();
                Set<String> authSet = new HashSet<>();
                for (String auth : auths) {
                    authSet.add(auth);
                }

                String role = (String) request.getSession().getAttribute("Sname");
                if (authSet.contains(role)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return true;
        }

        return false;
    }

}
