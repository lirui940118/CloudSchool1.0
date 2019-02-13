package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.service.CqjStudentService;

@Controller
@RequestMapping("student")
public class CqjStudentController {
	@Autowired
	CqjStudentService css;
	
	@RequestMapping("addStudents")
	@ResponseBody
	public int addStudents(@RequestBody List<CqjStudent> list) {
		css.addStudents(list);
		return 0;
	}
}
