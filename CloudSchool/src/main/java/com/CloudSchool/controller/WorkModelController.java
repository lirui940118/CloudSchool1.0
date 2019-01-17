package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.service.WorkMouldService;

@Controller
@RequestMapping("WorkModel")
public class WorkModelController {
	@Autowired
	WorkMouldService workMouldService;
	@RequestMapping("toWorkModel")
	public String toWorkModel() {
		return "zjf/workmodel";
	}
	@RequestMapping("queryWorkInfoById")
	@ResponseBody
	public Workinstance queryWorkInfoById(Integer id) {
		return workMouldService.queryWorkInfoById(id);
	}

}
