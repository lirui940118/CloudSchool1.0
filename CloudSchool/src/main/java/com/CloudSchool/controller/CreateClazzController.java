package com.CloudSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.service.ClazzService;

@Controller
public class CreateClazzController {
	@Autowired
	ClazzService cs;
	@ResponseBody
	@RequestMapping(value="createClazz",method=RequestMethod.GET)
	public String toCreateClazz() {
		return "createClazz";
	}
	@ResponseBody
	@RequestMapping(value="createClazz",method=RequestMethod.POST)
	public int createClazz(ClazzInfo c) {
		return cs.CreateClass(c);
	}
}
