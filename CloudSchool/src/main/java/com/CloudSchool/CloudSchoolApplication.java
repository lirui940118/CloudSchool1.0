package com.CloudSchool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.CloudSchool.dao")
@EnableScheduling
public class CloudSchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudSchoolApplication.class, args);
	}
}