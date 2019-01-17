package com.CloudSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("StudentWork")
public class StudentWorkController {
	
	@RequestMapping("studentWork")
	public String toStudentWork() {
		return "zjf/student/studentWork";
	}
}
