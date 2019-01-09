package com.CloudSchool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.CloudSchool.dao")
public class CloudSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSchoolApplication.class, args);
	}

}

