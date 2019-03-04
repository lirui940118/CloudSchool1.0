package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.Studentupgrade;
import com.CloudSchool.domain.cqjvo.ProgressInfo;
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
	
	
	@RequestMapping("queryStudetnTest")
	@ResponseBody
	public List<CqjStudent> queryStudetnTestByCid(HttpSession session) {
		ProgressInfo progressInfo=(ProgressInfo)session.getAttribute("progressInfo");
		return css.queryStudetnTestByCid(progressInfo.getCid(),progressInfo.getGid());
	}
	
	 @RequestMapping("addStudentUpGrade")
	 @ResponseBody
	 public void addStudentUpGrade(@RequestBody List<Studentupgrade> ids,HttpSession session) {
		 ProgressInfo progressInfo=(ProgressInfo)session.getAttribute("progressInfo");
		 //添加到升班
		 css.addStudentUpGrade(ids,progressInfo.getCid(),progressInfo.getGid(),progressInfo.getNgid());
		 session.removeAttribute("progressInfo");
	 }
	 @RequestMapping("getProgressInfo")
	 @ResponseBody
	 public Object getCGNid(HttpSession session) {
		 return session.getAttribute("progressInfo");
	 }
	 
	 @RequestMapping("getStudentJobInfo")
	 @ResponseBody
	 public Object getStudentJobInfo(HttpSession session) {
		 return css.queryStudentJob();
	 }
	 
	 @RequestMapping("updateStudentUpGrade")
	 @ResponseBody
	 public void updateStudentUpGrade(@RequestBody List<CqjStudent> ids){
		 System.out.println(1);
		 css.updateStudentUpGrade(ids);
	 }
}
