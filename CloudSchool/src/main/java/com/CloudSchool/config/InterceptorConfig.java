package com.CloudSchool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.CloudSchool.Interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	LoginInterceptor loginInterceptor;

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/static/**",
				"/user/login", "/user/goLogin","/user/goIndex","/user/goHome","/user/getInfo","/error","/module/getInfoModule");
	}
}
