package com.CloudSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.cqjvo.ProgressInfo;
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
			session.setAttribute("user", userinfo);
		}else {
			System.out.println("登录失败");
		}
		return "redirect:goIndex";
	}
	
	@RequestMapping("goLogin")
	public String goLogin(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "login";
		}
		return "redirect:goIndex";
	}
	@RequestMapping("exit")
	public String exit(HttpSession session) {
		session.invalidate(); 
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
	
	@RequestMapping("goUser")
	public String goUser() {
		return "cqj_setting/user";
	}
	@RequestMapping("goAddUser")
	public String goAddUser() {
		return "cqj_setting/user_insert";
	}
	@RequestMapping("goAddStudent")
	public String goAddStudent() {
		return "cqj_setting/student_insert";
	}
	@RequestMapping("getPage")
	@ResponseBody
	public PageBean getPage(Integer pageSize,String filtrate,Integer cur) {
		if(pageSize==null) {
			pageSize=50;
		}
		PageBean page=cus.pageUser(filtrate, cur, pageSize);
		return page;
	}
	@RequestMapping("/updateUser")
	@ResponseBody
	public int updateUser(CqjUser user) {
		
		return cus.updateUser(user);
	}
	@RequestMapping("/goProgressing")
	public String goProgressing(HttpSession session,Integer cid,Integer gid,Integer ngid) {
		if(cid!=null&&gid!=null&&ngid!=null) {
			ProgressInfo progressInfo=new ProgressInfo(cid, gid, ngid);
			if(session.getAttribute("progressInfo")!=null) {
				session.removeAttribute("session");
			}
			session.setAttribute("progressInfo", progressInfo);
			return "cqj_setting/progressing";
		}
		return "redirect:goIndex";
		
	}
	@RequestMapping("goStudentJob")
	public String goStudentJob() {
		return "cqj_setting/studentJob";
	}
}
