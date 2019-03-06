package com.CloudSchool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@MapperScan("com.CloudSchool.dao")
@EnableScheduling
@EnableWebSocket // 开启 socket通信
/*
 * @ComponentScan(basePackages= {"com.CloudSchool.timer.DynamicTaskJobs.java"})
 */public class CloudSchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudSchoolApplication.class, args);
	}

	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {

		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(100);
		taskScheduler.initialize();
		return taskScheduler;
	}
}
