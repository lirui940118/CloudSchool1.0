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
import com.CloudSchool.domain.statistics.ClazzBaseInfoVO;
import com.CloudSchool.domain.statistics.StudentInfoVO;
import com.CloudSchool.domain.statistics.TestInfo;
import com.CloudSchool.domain.statistics.testBaseInfo;
import com.CloudSchool.domain.statistics.testVO;
import com.CloudSchool.service.ClazzSService;
import com.CloudSchool.service.ClazzService;
import com.CloudSchool.service.CqjStudentService;
import com.CloudSchool.service.GkKaoqinStateService;
import com.CloudSchool.service.TestGradeService;
import com.CloudSchool.service.ZzyGradeService;
import com.alibaba.fastjson.JSON;

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
	@Autowired
	ClazzService clazzService;
	@Autowired
	ClazzSService clazzSService;
	/**
	 * 学员首页
	 * 
	 */
	/*打开学员首页*/
	@RequestMapping("/gotoStudent")
	public String gotoStudent() {
		return "statistics/student";
	}
	/*打开考试详细分析*/
	@RequestMapping("/gotoStudentText")
	public String gotoStudentText(String sId,Integer tId,HttpSession session) {//textGrade.Id
		//當前登陸賬號信息
		CqjUser cqjUser = (CqjUser)session.getAttribute("user");
		if(sId !=null) {//查其他学员
					
		}else {//查本人（学员）
			sId = cqjUser.getUsertypeid().toString();//doto session获取登陆学员的id
		}
		//保存至session
		session.setAttribute("lr_textGradeId", tId);
		session.setAttribute("lr_sId", sId);
		return "statistics/studentText";
	}
	/*打开班级成绩统计分析*/
	@RequestMapping("/gotoClazz")
	public String gotoClazz(Integer clazzId,HttpSession session) {//textGrade.Id
		
		//保存至session
		session.setAttribute("lr_clazzId", clazzId);
		return "statistics/clazz";
	}
	
	/*查询数据*/
	//============================个人=====================================
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
	//=============================考试==========================================
	/*查询考试基本信息数据*/
	@RequestMapping("/getDataAboutTestBase")
	@ResponseBody
	public testBaseInfo getDataAboutTestBase(HttpSession session) {
		/*session.setAttribute("lr_textGradeId", tId);
		session.setAttribute("lr_sId", sId);*/
		//获取需要查询的数据id
		Integer sId = Integer.parseInt(session.getAttribute("lr_sId").toString());
		Integer tId = Integer.parseInt(session.getAttribute("lr_textGradeId").toString());//testGrade.id
		testBaseInfo testbaseinfo = testGradeService.queryTestBaseInfoBySidAndtId(sId, tId);
		return testbaseinfo;
	}
	/*查询考试详细分析数据*/
	@RequestMapping("/getDataAboutTextInfo")
	@ResponseBody
	public TestInfo getDataAboutTextInfo(HttpSession session) {
		/*session.setAttribute("lr_textGradeId", tId);
		session.setAttribute("lr_sId", sId);*/
		//获取需要查询的数据id
		Integer sId = Integer.parseInt(session.getAttribute("lr_sId").toString());
		Integer tId = Integer.parseInt(session.getAttribute("lr_textGradeId").toString());//testGrade.id
		TestInfo testInfo = testGradeService.queryAllKnowledagePointBySidAndtId(sId, tId);
		return testInfo;
	}
	//============================班级=====================================
	/*查询班级基础信息数据*/
	@RequestMapping("/getDataAboutClazzBaseInfo")
	@ResponseBody
	public List<ClazzBaseInfoVO> getDataAboutClazzBaseInfo(HttpSession session) {
		/*session.setAttribute("lr_clazzId", clazzId);*/
		//获取需要查询的数据id
		Integer clazzId = (Integer)session.getAttribute("lr_clazzId");
		List<ClazzBaseInfoVO> list = clazzService.queryClazzBaseInfo(clazzId);
		return list;
	}
	/*查询一班级下学员的多次考试成绩数据*/
	@RequestMapping("/getStudentTestVoByStaffId")
	@ResponseBody
	public List<StudentInfoVO> getStudentTestVoByStaffId(HttpSession session,Integer staffId,Integer sortType) {//教员id
		/*session.setAttribute("lr_clazzId", clazzId);*/
		Integer clazzId = (Integer)session.getAttribute("lr_clazzId");
		List<StudentInfoVO> list = clazzSService.queryStudentTestVoBySidsAndTid(clazzId,staffId,sortType);
		//usertypeid 员工id
		return list;
	}
	
}
