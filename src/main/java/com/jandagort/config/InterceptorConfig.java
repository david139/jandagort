package com.jandagort.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    AuthenticateUserInterceptor authenticateUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptors){
        interceptors.addInterceptor(authenticateUserInterceptor);

    }
}
