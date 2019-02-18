package com.CloudSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.Testmodule;
import com.CloudSchool.service.TestModuleService;

@Controller
@RequestMapping("TestModule")
public class TestModuleController {
	
	@Autowired
	TestModuleService testModuleService;
	//跳转到生成试卷模板页面
	@RequestMapping("toTestAppearTopicWork")
	public String toTestAppearTopicWork() {
		return "zjf/test/testAppearTopicWork";
	}
	
	//生成试卷模板
	@RequestMapping("insertTestModule")
	@ResponseBody
	public int insertTestModule(@RequestBody Testmodule obj) {
		return testModuleService.insertTestModule(obj);
	}
}
