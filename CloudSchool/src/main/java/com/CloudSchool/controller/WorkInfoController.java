package com.CloudSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("WorkInfo")
public class WorkInfoController {
	//跳转到作业详情页面
	@RequestMapping("toWorkInfo")
	public String toWorkInfo() {
		return "zjf/workInfo";
	}

}
