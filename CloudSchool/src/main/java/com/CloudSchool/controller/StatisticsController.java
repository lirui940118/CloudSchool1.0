package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkKaoqinState;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.statistics.testVO;
import com.CloudSchool.service.CqjStudentService;
import com.CloudSchool.service.GkKaoqinStateService;
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
	@Autowired
	GkKaoqinStateService gkKaoqinStateService;
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
	public CqjStudent queryStudentInfoBySid(Integer sId,HttpSession session) {
		//當前登陸賬號信息
		CqjUser cqjUser = (CqjUser)session.getAttribute("user");
		if(sId !=null) {//查其他学员
					
		}else {//查本人（学员）
			sId = cqjUser.getUsertypeid();//doto session获取登陆学员的id
		}
		return cqjStudentService.queryStudentInfoBySid(sId);
	}
	/*查询该学员所读过的年级*/
	@RequestMapping("/queryGradeListBySid")
	@ResponseBody
	public List<ZzyGrade> queryGradeListBySid(Integer sId,HttpSession session){
		CqjUser cqjUser = (CqjUser)session.getAttribute("user");
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = cqjUser.getUsertypeid();//doto session获取登陆学员的id
		}
		return zzyGradeService.queryGradeListBySid(sId);
	}
	/*查询该学员当前所读年级*/
	@RequestMapping("/queryCurrentGradeBySid")
	@ResponseBody
	public ZzyGrade queryCurrentGradeBySid(Integer sId,HttpSession session) {
		CqjUser cqjUser = (CqjUser)session.getAttribute("user");
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = cqjUser.getUsertypeid();//doto session获取登陆学员的id
		}
		return zzyGradeService.queryCurrentGradeBySid(sId);
	}
	/*查询单个学员的所有考试成绩数据*/
	@RequestMapping("getDataAboutAllTestBySid")
	@ResponseBody
	public List<testVO> getDataAboutAllTestBySid(Integer sId,Integer gId,HttpSession session) {
		CqjUser cqjUser = (CqjUser)session.getAttribute("user");
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = cqjUser.getUsertypeid();//doto session获取登陆学员的id
		}
		List<testVO> list = testGradeService.querySimStudentTestGradeBySid(sId,gId);
		return list;
	}
	/*查询单个学员的所有考试成绩数据*/
	@RequestMapping("getDataAboutQkBySidAndGid")
	@ResponseBody
	public List<GkKaoqinState> getDataAboutQkBySidAndGid(Integer sId,Integer gId,HttpSession session) {
		CqjUser cqjUser = (CqjUser)session.getAttribute("user");
		if(sId !=null) {//查其他学员
			
		}else {//查本人（学员）
			sId = cqjUser.getUsertypeid();//doto session获取登陆学员的id
		}
		List<GkKaoqinState> list = gkKaoqinStateService.queryKqTotalInfoBySidAndGid(sId, gId);
		return list;
	}
}
