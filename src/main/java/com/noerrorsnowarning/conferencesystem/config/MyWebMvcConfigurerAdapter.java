package com.noerrorsnowarning.conferencesystem.config;

import com.noerrorsnowarning.conferencesystem.interceptor.AuthenticationInterceptor;
import com.noerrorsnowarning.conferencesystem.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MyInterceptor())
                .excludePathPatterns("/login/")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/admin/login/")
                .addPathPatterns("/**");

        registry.addInterceptor(new AuthenticationInterceptor())
                .addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}