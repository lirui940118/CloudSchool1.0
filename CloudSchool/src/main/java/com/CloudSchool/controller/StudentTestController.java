package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.zjfvo.StuTestInfo;
import com.CloudSchool.domain.zjfvo.TestInfo;
import com.CloudSchool.service.ParticipateteststuService;
import com.CloudSchool.service.WtrecordService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("StudentTestController")
public class StudentTestController {
	
	@Autowired
	WtrecordService wtrecordService;
	
	@Autowired
	ParticipateteststuService participateteststuService;
	
	@RequestMapping("toTestStuworkCorrectInfo")
	public String toTestStuworkCorrectInfo() {
		return "zjf/test/TestStuworkCorrectInfo";
	}
	
	@RequestMapping("tostudentTest")
	public String tostudentTest(Integer tid,HttpSession session) {
		session.setAttribute("Testid",tid);
		return "zjf/test/studentTest";
	}
	
	@RequestMapping("queryStuTestAllBySid")
	@ResponseBody
	public List<StuTestInfo> queryStuTestAllBySid(Integer sid,HttpSession session){
		CqjUser user=(CqjUser)session.getAttribute("user");
		return participateteststuService.queryStuTestAllBySid(user.getUsertypeid());
	}
	
	//查询考试试卷详情
	@RequestMapping("queryTestInfoBySidAndTid")
	@ResponseBody
	public TestInfo queryTestInfoBySidAndTid(Integer tid,HttpSession session) {
		CqjUser  user=(CqjUser)session.getAttribute("user");
		tid=(Integer)session.getAttribute("Testid");
		System.out.println(tid);
		return participateteststuService.queryTestInfoBySidAndTid(tid,user.getUsertypeid());
	}
	
	//考试提交
	@RequestMapping("testPublish")
	@ResponseBody
	public int testPublish(@RequestBody TestInfo obj) {
		System.out.println(JSON.toJSON(obj));
		return wtrecordService.testPublish(obj);
	}
	
	
}
