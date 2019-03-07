package com.noerrorsnowarning.conferencesystem.config;

import com.noerrorsnowarning.conferencesystem.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration addInterceptor = registry.addInterceptor(new MyInterceptor());

        //添加规则
        addInterceptor.excludePathPatterns("/login/");
        addInterceptor.excludePathPatterns("/static/**");
        addInterceptor.excludePathPatterns("/admin/login/");
        addInterceptor.addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}