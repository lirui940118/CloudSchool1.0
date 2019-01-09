package com.CloudSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("statistics")
public class StatisticsController {
	/**
	 * 学员首页
	 * 
	 */
	/*打开学员首页*/
	@RequestMapping("/gotoStudent")
	public String aa() {
		return "statistics/student";
	}
	
	
	
	
	
	/*查询数据*/
	
	/*查询单个学员的所有考试成绩数据*/
}
