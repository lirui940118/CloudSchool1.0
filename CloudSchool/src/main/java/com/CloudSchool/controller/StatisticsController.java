package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.statistics.testVO;
import com.CloudSchool.service.TestGradeService;

@Controller
@RequestMapping("statistics")
public class StatisticsController {           
	
	
	
	@Autowired
	TestGradeService testGradeService;
	/**
	 * 学员首页
	 * 
	 */
	/*打开学员首页*/
	@RequestMapping("/gotoStudent")
	public String aa() {
		return "statistics/student";
	}
	
	
	
	
	
	/*查询数据*/
	/*查询该学生所*/
	/*查询单个学员的所有考试成绩数据*/
	@RequestMapping("getDataAboutAllTestBySid")
	@ResponseBody
	public List<testVO> getDataAboutAllTestBySid(Integer sId) {
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = 1;//doto session获取登陆学员的id
		}
		return testGradeService.querySimStudentTestGradeBySid(sId);
	}
	
	
}
