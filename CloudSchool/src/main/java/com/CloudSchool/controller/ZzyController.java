package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.ZzyMajor;
import com.CloudSchool.domain.ZzyVersion;
import com.CloudSchool.service.ZzyCourseService;
import com.CloudSchool.service.ZzyGradeService;
import com.CloudSchool.service.ZzyMajorService;
import com.CloudSchool.service.ZzyVersionService;

@Controller
@RequestMapping("zzy")
public class ZzyController {
	@Autowired
	ZzyVersionService vers;
	
	@Autowired
	ZzyMajorService majs;
	
	@Autowired
	ZzyGradeService gras;
	
	@Autowired
	ZzyCourseService cous;
	
	//查询所有版本
	@RequestMapping("/queryAllversion")
	public String queryAllversion(Model model) {
		List<ZzyVersion> list = vers.queryAll();
		model.addAttribute("list", list);
		return "zzy/version.html";
	}
	
	//跳转新增版本页面
	@RequestMapping("/addVersion")
	public String addVersion() {
		return "zzy/addversion.html";
	}
	
	//添加版本方法
	@RequestMapping("/insertVersion")
	@ResponseBody
	public int insertVersion(@RequestBody ZzyVersion version) {
		vers.insert(version);
		return 1;
	}
	
	//添加专业方法
	@RequestMapping("/insertMajor")
	@ResponseBody
	public int insertMajor(@RequestBody List<ZzyMajor> major) {
		majs.insertList(major);
		return 1;
	}
	
	//跳转新增课程界面
	@RequestMapping("/addCourse")
	public String addCourse() {
		return "zzy/addcourse.html";
	}
	
	//使用Ajax查询所有版本
	@RequestMapping("/AjaxqueryAllVersion")
	@ResponseBody
	public List<ZzyVersion> AjaxqueryAllVersion(){
		return vers.queryAll();
	}
	
	//使用Ajax根据版本id查询所属年级
	@RequestMapping("/queryByvid")
	@ResponseBody
	public List<ZzyGrade> queryByvid(Integer vid){
		return gras.queryByvid(vid);
	}
	
	//查询所有专业
	@RequestMapping("/queryMajorAll")
	@ResponseBody
	public List<ZzyMajor> queryMajorAll(){
		return majs.queryAll();
	}
	
	//添加课程以及循环添加章节
	@RequestMapping("/insertCourse")
	@ResponseBody
	public int insertCourse(@RequestBody ZzyCourse course) {
		cous.insert(course);
		return 1;
	}
	
	//进入概览图
	@RequestMapping("/overview")
	public String overview(Integer vid,Model model) {
		model.addAttribute("vid", vid);
		return "zzy/overview.html";
	}
	
	//一对多查询版本以及版本里面的年级
	@RequestMapping("/VerAndGrade")
	@ResponseBody
	public ZzyVersion VerAndGrade(Integer vid) {
		return vers.VerAndGrade(vid); 
	}
	
	//一对多查询版本以及版本里面的年级,年级里面的课程,课程里面的章节
	@RequestMapping("/VerAndGrade2")
	@ResponseBody
	public ZzyVersion VerAndGrade2(Integer vid) {
		return vers.VerAndGrade2(vid); 
	}
}
