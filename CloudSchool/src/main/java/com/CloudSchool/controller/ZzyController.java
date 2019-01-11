package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.ZzyMajor;
import com.CloudSchool.domain.ZzyVersion;
import com.CloudSchool.service.ZzyVersionService;

@Controller
@RequestMapping("zzy")
public class ZzyController {
	@Autowired
	ZzyVersionService vers;
	
	//查询所有版本
	@RequestMapping("/queryAllversion")
	public String queryAllversion(Model model) {
		List<ZzyVersion> list = vers.queryAll();
		model.addAttribute("list", list);
		return "statistics/version.html";
	}
	
	//跳转新增版本页面
	@RequestMapping("/addVersion")
	public String addVersion() {
		return "statistics/addversion.html";
	}
	
	//添加版本方法
	@RequestMapping("insertVersion")
	@ResponseBody
	public int insertVersion(@RequestBody ZzyVersion version) {
		System.out.println(version.getVersionof());
		return 1;
	}
	
	//添加专业方法
	@RequestMapping("insertMajor")
	@ResponseBody
	public int insertMajor(@RequestBody List<ZzyMajor> major) {
		for (ZzyMajor zzyMajor : major) {
			System.out.println(zzyMajor.getMajorName());
		}
		return 1;
	}
	
	//跳转新增课程界面
}
