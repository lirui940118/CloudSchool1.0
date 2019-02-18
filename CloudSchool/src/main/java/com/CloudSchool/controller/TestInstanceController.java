package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.service.TestInstanceService;

@Controller
@RequestMapping("TestInstance")
public class TestInstanceController {
	
	@Autowired
	TestInstanceService testInstanceService;
	//跳转到试卷发布
	@RequestMapping("toTestPublishWork")
	public String toTestPublishWork() {
		return "zjf/test/testPublishWork";
	}
	
	
	/***
	 * 查询所有年级  
	 * @param id
	 * @return
	 */
	@RequestMapping("queryGrade")
	@ResponseBody
	public List<ZzyGrade> queryGrade(String id){
		return testInstanceService.queryGrade(id);
	}
}
