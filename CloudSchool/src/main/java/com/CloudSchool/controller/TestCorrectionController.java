package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.dao.ParticipateteststuMapper;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Participatetestclass;
import com.CloudSchool.domain.Participateteststu;
import com.CloudSchool.domain.zjfvo.TeachTestCorrect;
import com.CloudSchool.domain.zjfvo.TestInfoAll;
import com.CloudSchool.service.ParticipatetestcCassService;
import com.CloudSchool.service.ParticipateteststuService;
import com.CloudSchool.service.TestGradeService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("TestCorrectionController")
public class TestCorrectionController {
	
	@Autowired
	ParticipatetestcCassService participatetestcCassService;
	@Autowired
	ParticipateteststuService participateteststuService;
	@Autowired
	TestGradeService testGradeService;
	
	//根据用户id查询到要批改的试卷
	@RequestMapping("queryMyCorrectTest")
	@ResponseBody
	public List<TeachTestCorrect> queryMyCorrectTest(Integer uid,HttpSession  session){
		CqjUser user=(CqjUser)session.getAttribute("user");
		return participatetestcCassService.queryMyCorrectTest(user.getUsertypeid());
	}
	
	@RequestMapping("toTestCorrectInfo")
	public String toTestCorrectInfo() {
		return "zjf/test/TestCorrectInfo";
	}
	
	@RequestMapping("toTestCorrect")
	public String toTestCorrect(Integer tid,Integer cid,HttpSession session) {
		session.setAttribute("TestCorrecttid", tid);
		session.setAttribute("TestCorrectcid", cid);
		return "zjf/test/TestCorrect";
	}
	
	
	//根据班级id和考试实例id查询本次考试详细信息
	@RequestMapping("queryByTidTestInfo")
	@ResponseBody
	public List<TestInfoAll> queryByTidTestInfo(HttpSession session) {
		Integer tid=(Integer)session.getAttribute("TestCorrecttid");
		Integer cid=(Integer)session.getAttribute("TestCorrectcid");
		return participatetestcCassService.queryByTidTestInfo(tid,cid);
	}
	
	@RequestMapping("queryTestInfoBySidAndTidCorrect")
	@ResponseBody
	public PageBean queryTestInfoBySidAndTidCorrect(Integer id, Integer sid, Integer cur, Integer pagesize) {
		if(pagesize==null) {
			pagesize=1;
		}
		return participateteststuService.queryTestInfoBySidAndTidCorrect(id, sid, cur, pagesize);
	}
	
	
	@RequestMapping("testCorrectSubmit")
	@ResponseBody
	public int testCorrectSubmit(Participateteststu stu) {
		return testGradeService.testCorrect(stu);
	}
	
	@RequestMapping("updateTestClassStatus")
	@ResponseBody
	public int updateTestClassStatus(Participatetestclass obj,HttpSession session) {
		Integer cid=(Integer)session.getAttribute("TestCorrectcid");
		Integer tid=(Integer)session.getAttribute("TestCorrecttid");
		session.removeAttribute("TestCorrectcid");
		session.removeAttribute("TestCorrecttid");
		obj.setCid(cid);
		obj.setTid(tid);
		System.out.println(JSON.toJSONString(obj));
		return participatetestcCassService.updateTestClassStatus(obj);
	}
	
	@RequestMapping("toTestinfo")
	public String toTestinfo(Integer tid,Integer cid,HttpSession session) {
		System.out.println("******************************");
		session.setAttribute("TestCorrecttid", tid);
		session.setAttribute("TestCorrectcid", cid);
		return "zjf/test/testinfo";
	}
	
}
