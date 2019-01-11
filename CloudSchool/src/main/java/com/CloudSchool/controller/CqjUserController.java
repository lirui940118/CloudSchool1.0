package com.CloudSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjUserService;

@Controller
@RequestMapping("user")
public class CqjUserController {
	@Autowired
	CqjUserService cus;
	
	
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		CqjUser userinfo=cus.login(username, password);
		if(userinfo!=null) {
			System.out.println("登录成功");
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
	public String goIndex() {
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
}