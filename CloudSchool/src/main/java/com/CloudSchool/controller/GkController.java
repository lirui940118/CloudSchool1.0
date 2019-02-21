package com.CloudSchool.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.standard.expression.Each;

import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.CqjParents;
import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkKaoqinState;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.domain.GkQuestionnaire;
import com.CloudSchool.service.ClazzService;
import com.CloudSchool.service.CqjPositionService;
import com.CloudSchool.service.CqjStudentService;
import com.CloudSchool.service.CqjUserService;
import com.CloudSchool.service.GkFangTanService;
import com.CloudSchool.service.GkKaoQinService;
import com.CloudSchool.service.GkKaoqinStateService;
import com.CloudSchool.service.GkWenJuanService;

@Controller
@RequestMapping("/GK/")
public class GkController {
	
	//访谈
	@Autowired
	GkFangTanService gkFangTanService;
	//考勤
	@Autowired
	GkKaoQinService gkKaoQinService;
	//所有职位
	@Autowired
	CqjPositionService cqjPositionService;
	//考勤状态
	@Autowired
	GkKaoqinStateService gkKaoqinStateService;
	//cqj学生
	@Autowired
	CqjStudentService cqjStudentService;
	//班级
	@Autowired
	ClazzService clazzService;
	//问卷
	@Autowired
	GkWenJuanService gkWenJuanService;
	
	
	//去查询问卷页面
	@RequestMapping("toQuestionnaire_Release_Records")
	public String toQuestionnaire_Release_Records() {
		return "gk/Questionnaire_Release_Records";
	}
	//查询所有问卷发布记录
	@RequestMapping("queryAllWenJuanFaBuJiLu")
	@ResponseBody
	public GkPageBean<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj){
		return gkWenJuanService.queryAllWenJuanFaBuJiLu(wj);
	}
	//去班级考勤页面
	@RequestMapping("toStudent_attendance")
	public String toStudent_attendance(Model model) {
		//查询所有班级
		List<Clazz> banji = clazzService.queryAllBanJi();
		model.addAttribute("banji", banji);
		return "gk/Student_attendance";
	}
	//查询所有班级考勤信息
	@RequestMapping("queryAllKaoQinBanJi")
	@ResponseBody
	public GkPageBean<GkKaoqin> queryAllKaoQinBanJi(GkKaoqin kq){
		return gkKaoQinService.queryAllKaoQinBanJi(kq);
	}
	//去员工考勤页面
	@RequestMapping("toEmployee_attendance")
	public String toEmployee_attendance(Model model) {
		//查询所有职位
		List<CqjPosition> zhiwei = cqjPositionService.qeuryAllposition();
		model.addAttribute("zhiwei", zhiwei);
		return "gk/Employee_attendance";
	}
	//查询所有员工考勤信息
	@RequestMapping("queryAllKaoQinYuanGong")
	@ResponseBody
	public GkPageBean<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq){
		return gkKaoQinService.queryAllKaoQinYuanGong(kq);
	}
	//查询某段时间内的考勤状况（员工）
	@RequestMapping("queryKaoQinYuanGongXiangByTime")
	@ResponseBody
	public List<GkKaoqin> queryKaoQinYuanGongXiangByTime(Integer userid,String startStr,String endStr){
		return gkKaoQinService.queryKaoQinYuanGongXiangByTime(userid, startStr, endStr);
	}
	
	//去录入班级考勤页面
	@RequestMapping("toAttendance_input")
	public String toAttendance_input(Model model) {
		List<GkKaoqinState> kqstate = gkKaoqinStateService.queryAllKaoQinState();
		model.addAttribute("kqstate", kqstate);
		model.addAttribute("banjiname",clazzService.queryBanJiByUserid(2));
		int y,m,d,h,mi,s;    
		Calendar cal=Calendar.getInstance();    
		y=cal.get(Calendar.YEAR);    
		m=cal.get(Calendar.MONTH);    
		d=cal.get(Calendar.DATE);    
		h=cal.get(Calendar.HOUR_OF_DAY);    
		mi=cal.get(Calendar.MINUTE);    
		s=cal.get(Calendar.SECOND);    
		//System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
		String time = y+"-"+m+"-"+d;
		model.addAttribute("time", time);
		return "gk/Attendance_input";
	}
	//通过学生id查询所在班级所有学生
	@RequestMapping("queryTongXueByUserid")
	@ResponseBody
	public List<CqjStudent> queryTongXueByUserid(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
	
		return cqjStudentService.queryTongXueByUserid(2);
	}
	//新增班级当天考勤 
	@RequestMapping(value="insertBanJiKaoQin",produces="application/json")
	@ResponseBody
	public int insertBanJiKaoQin(@RequestBody List<GkKaoqin> list) {
		Clazz ss = clazzService.queryBanJiByUserid(2);
		return gkKaoQinService.insertBanJiKaoQin(list,ss.getId(),ss.getGid());
	}
	//判断是否已经考勤
	@RequestMapping("queryKaoQinPanDuan")
	@ResponseBody
	public int queryKaoQinPanDuan() {
		GkKaoqin kq = gkKaoQinService.queryKaoQinPanDuan(9);
		if(kq == null) {
			return 0;
		}else {
			return 1;
		}
	}
	//修改班级当天考勤状态
	@RequestMapping(value="updateKaoQinBanJi",produces="application/json")
	@ResponseBody
	public int updateKaoQinBanJi(@RequestBody List<GkKaoqin> list) {
		int counts = 0;
		for (GkKaoqin gkKaoqin : list) {
			int count = gkKaoQinService.updateKaoQinBanJi(gkKaoqin.getKqStateId(), gkKaoqin.getUid());
			if(count > 0) {
				counts++;
			}
		}
		return counts;
	};
	
	
	
	
	
	
	/*
	 * 			访谈访谈访谈访谈访谈访谈访谈访谈访谈访谈访谈访谈访谈访谈访谈
	 */
	//去我的访谈
	@RequestMapping("goMyFangTan")
	public String goMyFangTan() {
		return "gk/Fill_interview";
	}
	//查询未完成的访谈（个人），别人发起
	@RequestMapping("queryFangTanByWWCB")
	@ResponseBody
	public List<GkInterview> queryFangTanByWWCB(HttpSession session,Model model){
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByWWCB(user.getUserid());
	}
	//查询已完成的访谈（个人,别人发起）
	@RequestMapping("queryFangTanByYWCB")
	@ResponseBody
	public List<GkInterview> queryFangTanByYWCB(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByYWCB(user.getUserid());
	}
	//查询未完成的访谈（个人），我发起
	@RequestMapping("queryFangTanByWWCW")
	@ResponseBody
	public List<GkInterview> queryFangTanByWWCW(HttpSession session,Model model){
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByWWCW(user.getUserid());
	}
	//查询已完成的访谈（个人,我发起）
	@RequestMapping("queryFangTanByYWCW")
	@ResponseBody
	public List<GkInterview> queryFangTanByYWCW(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByYWCW(user.getUserid());
	}
	
	
	//完善访谈
	@RequestMapping("updateFangTanWS")
	public void updateFangTanWS(Integer ftId,String ftObjectExplain) {
		gkFangTanService.updateFangTanWS(ftId, ftObjectExplain);
	}
	//查询所有访谈
	@RequestMapping("queryAllFangTan")
	@ResponseBody
	public GkPageBean<GkInterview> queryAllFangTan(GkInterview ft){
		GkPageBean<GkInterview> zz=null;
		try {
			zz=gkFangTanService.queryAllFangTan(ft);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return zz;
	}
	//去访谈页面
	@RequestMapping("toInterview")
	public String toInterview() {
		return "gk/Interview";
	}
	//通过访谈id查询访谈详情
	@RequestMapping("queryFangTanDetailsByftid")
	@ResponseBody
	public GkInterview queryFangTanDetailsByftid(Integer ftId) {
		return gkFangTanService.queryFangTanDetailsByftid(ftId);
	}
	//通过访谈id删除访谈
	@RequestMapping("deleteFangTanByftId")
	@ResponseBody
	public int deleteFangTanByftId(int[] shuzu,HttpSession session) {
		return gkFangTanService.deleteFangTanByftId(shuzu);
	}
	//去新增访谈
	@RequestMapping("toNew_interview")
	public String toNew_interview(Model model,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		model.addAttribute("user", user);
		return "gk/New_interview";
	}
	//新增访谈
	@RequestMapping(value="insertFangTan")
	@ResponseBody
	public int insertFangTan(GkInterview ft) {
		Integer[] shuzu = ft.getShuzu();
		return gkFangTanService.insertFangTan(ft,shuzu);
	}
	//查询所有学生（按姓名模糊查）
	@RequestMapping("queryAllXueSheng")
	@ResponseBody
	public List<GkInterview> queryAllXueSheng(@Param(value="name")String name){
		return gkFangTanService.queryAllXueSheng(name);
	}
	//查询所有家长（按姓名模糊查）
	@RequestMapping("queryAllJiaZhang")
	@ResponseBody
	public List<GkInterview> queryAllJiaZhang(String name){
		return gkFangTanService.queryAllJiaZhang(name);
	}
	//查询所有员工（按姓名模糊查）
	@RequestMapping("queryAllYuanGong")
	@ResponseBody
	public List<GkInterview> queryAllYuanGong(String name){
		return gkFangTanService.queryAllYuanGong(name);
	}
}
