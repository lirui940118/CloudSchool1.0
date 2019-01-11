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
	@RequestMapping("/addClassRoom")
	@ResponseBody
	public String addClassRoom(Classroom classroom) {
		int i=cls.insertSelective(classroom);
		if(i>0) {
			System.out.println("成功！");
		}
		return "新增成功！";
	}
	@RequestMapping("/delClassRoom")
	public String delClassRoom(Integer id) {
		int i=cls.delete(id);
		if(i>0) {
			System.out.println("成功！");
		}
		return "删除成功！";
	}
	@RequestMapping("/selectByid")
	public String selectByid(Integer id,Model model) {
		Classroom cs=cls.selectByid(id);
		model.addAttribute("cs", cs);
		List<Classtype> list=clt.query();
		model.addAttribute("list", list);
		return "updateClassroom";
	}
	@RequestMapping("/updateClassRoom")
	@ResponseBody
	public String updateClassRoom(Classroom classroom) {
		int i=cls.update(classroom);
		if(i>0) {
			System.out.println("成功！");
		}
		return "修改成功！";
	}
}
