package com.CloudSchool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
		registry.addResourceHandler("/static/**","/baidueditor/**").addResourceLocations("classpath:/static/","file:e:\\img\\");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/static/**",
				"/user/login", "/user/goLogin","/user/goIndex","/user/goHome","/user/getInfo","/error","/module/getInfoModule","/position/getPosition","/role/getRole");
	}
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowCredentials(true);
		super.addCorsMappings(registry);
	}
}
