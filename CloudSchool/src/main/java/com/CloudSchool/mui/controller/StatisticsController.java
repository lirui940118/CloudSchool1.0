package com.CloudSchool.mui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {
	@RequestMapping("/aaa")
	public String aa() {
		return "123";
	}
}
