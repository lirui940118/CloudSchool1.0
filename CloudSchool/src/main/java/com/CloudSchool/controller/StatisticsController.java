package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.statistics.testVO;
import com.CloudSchool.service.CqjStudentService;
import com.CloudSchool.service.TestGradeService;
import com.CloudSchool.service.ZzyGradeService;

@Controller
@RequestMapping("statistics")
public class StatisticsController {           
	
	
	
	@Autowired
	TestGradeService testGradeService;
	@Autowired
	ZzyGradeService zzyGradeService;
	@Autowired
	CqjStudentService cqjStudentService;
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
	/*查询该学员个人信息*/
	@RequestMapping("/queryStudentInfoBySid")
	@ResponseBody
	public CqjStudent queryStudentInfoBySid(Integer sId) {
		if(sId !=null) {//查其他学员
					
		}else {//查本人（学员）
			sId = 1;//doto session获取登陆学员的id
		}
		return cqjStudentService.queryStudentInfoBySid(sId);
	}
	/*查询该学员所读过的年级*/
	@RequestMapping("/queryGradeListBySid")
	@ResponseBody
	public List<ZzyGrade> queryGradeListBySid(Integer sId){
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = 1;//doto session获取登陆学员的id
		}
		return zzyGradeService.queryGradeListBySid(sId);
	}
	/*查询该学员当前所读年级*/
	@RequestMapping("/queryCurrentGradeBySid")
	@ResponseBody
	public ZzyGrade queryCurrentGradeBySid(Integer sId) {
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = 1;//doto session获取登陆学员的id
		}
		return zzyGradeService.queryCurrentGradeBySid(sId);
	}
	/*查询单个学员的所有考试成绩数据*/
	@RequestMapping("getDataAboutAllTestBySid")
	@ResponseBody
	public List<testVO> getDataAboutAllTestBySid(Integer sId,Integer gId) {
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = 1;//doto session获取登陆学员的id
		}
		List<testVO> list = testGradeService.querySimStudentTestGradeBySid(sId,gId);
		return list;
	}
	
	
}
