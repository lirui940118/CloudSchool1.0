package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.zjfvo.StuTestInfo;
import com.CloudSchool.domain.zjfvo.TestInfo;
import com.CloudSchool.service.ParticipateteststuService;

@Controller
@RequestMapping("StudentTestController")
public class StudentTestController {
	
	@Autowired
	ParticipateteststuService participateteststuService;
	
	@RequestMapping("toTestStuworkCorrectInfo")
	public String toTestStuworkCorrectInfo() {
		return "zjf/test/TestStuworkCorrectInfo";
	}
	
	@RequestMapping("queryStuTestAllBySid")
	@ResponseBody
	public List<StuTestInfo> queryStuTestAllBySid(Integer sid,HttpSession session){
		CqjUser user=(CqjUser)session.getAttribute("user");
		return participateteststuService.queryStuTestAllBySid(user.getUsertypeid());
	}
	
	@RequestMapping("queryTestInfoBySidAndTid")
	@ResponseBody
	public TestInfo queryTestInfoBySidAndTid(Integer id, Integer sid) {
		return participateteststuService.queryTestInfoBySidAndTid(id, sid);
	}
}
