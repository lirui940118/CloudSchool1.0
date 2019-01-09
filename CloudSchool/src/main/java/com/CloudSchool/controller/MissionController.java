package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.Classroom;
import com.CloudSchool.domain.Classtype;
import com.CloudSchool.service.ClassroomService;
import com.CloudSchool.service.ClasstypeService;

@Controller
@RequestMapping("/mission")
public class MissionController {
	@Autowired
	ClassroomService cls;
	@Autowired
	ClasstypeService clt;
	
	@RequestMapping("/aaa")
	public String aaa(Model model) {
		List<Classroom> list=cls.query();
		model.addAttribute("list", list);
		return "ClassRoom";
	}
	@RequestMapping("/bbb")
	public String bbb(Model model) {
		List<Classtype> list=clt.query();
		model.addAttribute("list", list);
		return "insertClassroom";
	}
}
