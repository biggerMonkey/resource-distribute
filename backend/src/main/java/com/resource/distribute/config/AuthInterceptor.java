package com.resource.distribute.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.resource.distribute.interceptor.LoginHandleInterceptor;


@Configuration
@Order(10)
public class AuthInterceptor extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] swagger = new String[] {"/swagger**", "/v2/api-docs"};
        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/resource/user/login")
                .excludePathPatterns("/resource/user/check/*").excludePathPatterns("/error")
                .excludePathPatterns(swagger);
        super.addInterceptors(registry);
    }
}
