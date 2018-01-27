package com.jandagort.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@AllArgsConstructor
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    private AuthenticateUserInterceptor authenticateUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptors) {
        interceptors.addInterceptor(authenticateUserInterceptor);

    }
}
