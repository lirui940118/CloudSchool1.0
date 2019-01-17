package com.CloudSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjMoudelService;
import com.CloudSchool.service.CqjUserService;
import com.CloudSchool.timer.DynamicTaskJobs;
import com.CloudSchool.timer.ExamTaskJob;

@Controller
@RequestMapping("user")
public class CqjUserController {
	@Autowired
	CqjUserService cus;
	@Autowired
	CqjMoudelService cms;
	@Autowired
	DynamicTaskJobs dynamicTaskJobs;
	@Autowired
	ExamTaskJob examTaskJob;
	
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		CqjUser userinfo=cus.login(username, password);
		if(userinfo!=null) {
			System.out.println("登录成功");
			examTaskJob.setI(20);
			examTaskJob.setB("你好");
			//dynamicTaskJobs.addTaskTimerJob(examTaskJob, "*/5 * * * * *");
			//dynamicTaskJobs.addTaskJob(examTaskJob,"2019-01-17 08:49:10");
			session.setAttribute("user", userinfo);
		}else {
			System.out.println("登录失败");
		}
		return "redirect:goIndex";
	}
	
	@RequestMapping("goLogin")
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping("goIndex")
	public String goIndex(HttpSession session) {
		CqjUser userinfo=(CqjUser)session.getAttribute("user");
		if(userinfo==null) {
			return "login";
		}
		return "index";
	}
	
	@RequestMapping("goUrl")
	public String goUrl(String url) {
		return url;
	}
	
	@RequestMapping("goHome")
	public String goHome(String url) {
		return "login";
	}
	
	@RequestMapping("getInfo")
	@ResponseBody
	public CqjUser getInfo(HttpSession session) {
		CqjUser userinfo =(CqjUser)session.getAttribute("user");
		userinfo=cms.queryByUser(userinfo);
		return userinfo;
	}
}
