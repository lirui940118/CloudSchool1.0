package com.CloudSchool.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.CloudSchool.dao.CqjStaffMapper;
import com.CloudSchool.dao.GkWjcsMapper;
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
import com.CloudSchool.domain.GkQuestionnairetm;
import com.CloudSchool.domain.GkQuestionnairexx;
import com.CloudSchool.domain.GkWjcsjf;
import com.CloudSchool.service.ClazzService;
import com.CloudSchool.service.CqjPositionService;
import com.CloudSchool.service.CqjStaffService;
import com.CloudSchool.service.CqjStudentService;
import com.CloudSchool.service.CqjUserService;
import com.CloudSchool.service.GkFangTanService;
import com.CloudSchool.service.GkKaoQinService;
import com.CloudSchool.service.GkKaoqinStateService;
import com.CloudSchool.service.GkWenJuanService;
import com.CloudSchool.service.GkWjcsService;
import com.CloudSchool.service.GkWjcsjfService;
import com.alibaba.fastjson.JSON;

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
	//员工
	@Autowired
	CqjStaffService cqjStaffService;
	//用户
	@Autowired
	CqjUserService cqjUserService;
	//问卷测试选择题
	@Autowired
	GkWjcsService gkWjcsService;
	//问卷测试计分题
	@Autowired
	GkWjcsjfService gkWjcsjfService;
	
	
	//新增问卷题目	sql
	@RequestMapping("insertTiMu")
	@ResponseBody
	public int insertTiMu(@RequestBody GkQuestionnairetm tm,HttpSession session) {
//		System.out.println(JSON.toJSON(tm));
//		System.out.println(JSON.toJSON(tm.getListxx()));
		CqjUser user=(CqjUser)session.getAttribute("user");
		tm.setChutirenId(user.getUserid());
		int count = gkWenJuanService.insertTiMu(tm);
		if(tm.getBy1().equals("1")){
			List<GkQuestionnairexx> listxx = tm.getListxx();
			for(int i = 0;i<tm.getListxx().size();i++) {
				listxx.get(i).setWjxxFkTmid(tm.getWjtmId());
			}
			gkWenJuanService.insertXX(listxx);
		}
		return count;
	}
	//去创建题目页面	sql
	@RequestMapping("toNewProblem")
	public String toNewProblem(Model model) {
		model.addAttribute("tm", gkWenJuanService.queryAllTiMuType());
		model.addAttribute("xx", gkWenJuanService.queryAllXXLeiXing());
		model.addAttribute("wj", gkWenJuanService.queryAllWenJuanLeiXing());
		
		return "gk/NewProblem";
	}
	
	
	//完善问卷（计分）		sql
	@RequestMapping("insertWjcsjfWS")
	@ResponseBody
	public int insertWjcsjfWS(@RequestBody List<GkWjcsjf> list) {
		//修改问卷状态
		gkWjcsjfService.updateWjcsjf(list.get(0).getWjcsjfId());
		return gkWjcsjfService.insertWjcsjfWS(list);
	}
	//刷新我的问卷页面	sql
	@RequestMapping("resetMyWenJuan")
	@ResponseBody
	public GkPageBean<GkQuestionnaire> resetMyWenJuan(GkQuestionnaire wj){
		return gkWenJuanService.queryinsertByUserid(wj);
	}
	//去我的问卷页面	sql
	@RequestMapping("toMyWenJuan")
	public String toMyWenJuan(HttpSession session,Model model) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		model.addAttribute("zId", user.getUserid());
		return "gk/MyWenJuan";
	}
	
	
	
	
	//新增问卷发布记录	sql
	@RequestMapping("insertWenJuanFB")
	@ResponseBody
	public int insertWenJuanFB(@RequestBody GkQuestionnaire ft,HttpSession session) {
		//全部
		List<CqjUser> quanbulist = new ArrayList<CqjUser>();
		//学生userid集合
		List<CqjUser> studentidlist = new ArrayList<CqjUser>();
		for (Integer bj : ft.getBanji()) {
			//查询学生userid  by  班级id
			List<CqjUser> banji = cqjUserService.queryUseridByCid(bj);
			studentidlist.addAll(banji);
		}
		//家长userid集合
		List<CqjUser> parentsidlist = new ArrayList<CqjUser>();
		for (Integer jz : ft.getJiazhang()) {
			//查询家长userid  by  班级id
			List<CqjUser> jiazhang = cqjUserService.queryJZuseridBycid(jz);
			parentsidlist.addAll(jiazhang);
			//去掉家长集合里重复的家长userid
			for (int i = 0; i < parentsidlist.size() - 1; i++) {// 从第一个数开始，到最后一个数-1次循环
				for (int j = parentsidlist.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
					if (parentsidlist.get(i).getUserid() == parentsidlist.get(j).getUserid()) {
						parentsidlist.remove(j);// 这里的remove里的参数j就是角标，通过角标移除数据
					}
				}
			}
		}
		quanbulist.addAll(studentidlist);
		quanbulist.addAll(parentsidlist);
		quanbulist.addAll(ft.getYuangong());
		
		//新增问卷发布记录表gk_questionnaire
		CqjUser user=(CqjUser)session.getAttribute("user");
		ft.setWjPublisher(100);
		System.out.println(JSON.toJSON(ft));
		
		if(ft.getWjxxTypeId() == 1) {
			//插入选择题
			gkWjcsService.insertWjcs(quanbulist, ft.getWjId());
		}
		if(ft.getWjxxTypeId() == 2) {
			//插入计分题
			gkWjcsjfService.insertWjcsjf(quanbulist, ft.getWjId(), ft.getzId());
			if(ft.getWjTypeId() == 2 || ft.getWjTypeId() == 3) {
				//判断是否为调查教员或调查班主任问卷，true带出zid
				CqjUser yonghu = cqjUserService.queryWJcsjfPD();
				//通过zid带出所有记录
				List<GkWjcsjf> wjcsjfList = gkWjcsjfService.queryAllByzid(yonghu.getUserid());
				//互换oid，zid位置
				for (GkWjcsjf gkWjcsjf : wjcsjfList) {
					GkWjcsjf jf = new GkWjcsjf();
					jf.setoId(gkWjcsjf.getoId());
					jf.setzId(gkWjcsjf.getzId());
					jf.setWjcsjfId(gkWjcsjf.getWjcsjfId());
					gkWjcsjfService.updateByoidAndzid(jf);
				}
			}
			
		}
		
		return gkWenJuanService.insertWenJuanFB(ft);
	}
	//通过班级名称模糊查	sql
	@RequestMapping("queryAllBanJiByLikeName")
	@ResponseBody
	public List<Clazz> queryAllBanJiByLikeName(String name){
		return clazzService.queryAllBanJiByLikeName(name);
	}
	//通过问卷id查询说明	sql
	@RequestMapping("queryShuoMingBywjId")
	@ResponseBody
	public GkQuestionnaire queryShuoMingBywjId(Integer wjId) {
		return gkWenJuanService.queryShuoMingBywjId(wjId);
	}	
	//通过问卷类型，选项类型查询问卷	sql
	@RequestMapping("queryWenJuanBywjTypeIdAndwjxxTypeId")
	@ResponseBody
	public List<GkQuestionnaire> queryWenJuanBywjTypeIdAndwjxxTypeId(Integer wjTypeId,Integer wjxxTypeId){
		return gkWenJuanService.queryWenJuanBywjTypeIdAndwjxxTypeId(wjTypeId, wjxxTypeId);
	}
	//去发布问卷页面	sql
	@RequestMapping("toPublish_questionnaire")
	public String toPublish_questionnaire(Model model) {
		model.addAttribute("xx", gkWenJuanService.queryAllXXLeiXing());
		model.addAttribute("wj", gkWenJuanService.queryAllWenJuanLeiXing());
		model.addAttribute("jy", cqjUserService.queryAllJiaoYuan());
		return "gk/Publish_questionnaire";
	}
	
	
	//创建问卷   sql
	@RequestMapping("insertWenJuanCJ")
	@ResponseBody
	public int insertWenJuanCJ(GkQuestionnaire wj,HttpSession session) {
		Integer[] shuzu = wj.getShuzu();
		//新增问卷表
		CqjUser user=(CqjUser)session.getAttribute("user");
		wj.setWjPublisher(user.getUserid());
		gkWenJuanService.insertWenJuanCJ(wj);
		//新增问卷题目关联表
		return gkWenJuanService.insertWJTMFK(shuzu, wj.getWjId());
	}  
	//去创建问卷页面	sql
	@RequestMapping("toNew_questionnaire")
	public String toNew_questionnaire(Model model) {
		model.addAttribute("xx", gkWenJuanService.queryAllXXLeiXing());
		model.addAttribute("wj", gkWenJuanService.queryAllWenJuanLeiXing());
		return "gk/New_questionnaire";
	}
	//通过问卷类型，选项类型查询题目		sql
	@RequestMapping("queryAllTiMuByXXandwj")
	@ResponseBody
	public List<GkQuestionnairetm> queryAllTiMuByXXandwj(Integer xx,Integer wj){
		return gkWenJuanService.queryAllTiMuByXXandwj(xx, wj);
	}
	
	
	//去查询问卷页面   sql
	@RequestMapping("toQuestionnaire_Release_Records")
	public String toQuestionnaire_Release_Records() {
		return "gk/Questionnaire_Release_Records";
	}
	//查询所有问卷发布记录	sql
	@RequestMapping("queryAllWenJuanFaBuJiLu")
	@ResponseBody
	public GkPageBean<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj){
		return gkWenJuanService.queryAllWenJuanFaBuJiLu(wj);
	}
	//去班级考勤页面  sql
	@RequestMapping("toStudent_attendance")
	public String toStudent_attendance(Model model) {
		//查询所有班级
		List<Clazz> banji = clazzService.queryAllBanJi();
		model.addAttribute("banji", banji);
		return "gk/Student_attendance";
	}
	//查询所有班级考勤信息	sql
	@RequestMapping("queryAllKaoQinBanJi")
	@ResponseBody
	public GkPageBean<GkKaoqin> queryAllKaoQinBanJi(GkKaoqin kq){
		return gkKaoQinService.queryAllKaoQinBanJi(kq);
	}
	//去员工考勤页面   sql
	@RequestMapping("toEmployee_attendance")
	public String toEmployee_attendance(Model model) {
		//查询所有职位
		List<CqjPosition> zhiwei = cqjPositionService.qeuryAllposition();
		model.addAttribute("zhiwei", zhiwei);
		return "gk/Employee_attendance";
	}
	//查询所有员工考勤信息	sql
	@RequestMapping("queryAllKaoQinYuanGong")
	@ResponseBody
	public GkPageBean<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq){
		return gkKaoQinService.queryAllKaoQinYuanGong(kq);
	}
	//查询某段时间内的考勤状况（员工）     sql
	@RequestMapping("queryKaoQinYuanGongXiangByTime")
	@ResponseBody
	public List<GkKaoqin> queryKaoQinYuanGongXiangByTime(Integer userid,String startStr,String endStr){
		return gkKaoQinService.queryKaoQinYuanGongXiangByTime(userid, startStr, endStr);
	}
	
	//通过用户id查询自己所有考勤ajax		sql
	@RequestMapping("queryKaoQinByUseridajax")
	@ResponseBody
	public GkPageBean<GkKaoqin> queryKaoQinByUseridajax(GkKaoqin kq){
		return gkKaoQinService.queryKaoQinByUserid(kq);
	}
	//通过用户id查询自己所有考勤		sql
	@RequestMapping("queryKaoQinByUserid")
	public String queryKaoQinByUserid(String name,Integer userid,Model model) {
		//todo
		model.addAttribute("userid", userid);
		model.addAttribute("name", name);
		return "gk/KaoQinByUserId";
	}
	
	//去员工考勤页面    sql
	@RequestMapping("toAttendance_inputYG")
	public String toAttendance_inputYG(Model model) {
		List<GkKaoqinState> kqstate = gkKaoqinStateService.queryAllKaoQinState();
		model.addAttribute("kqstate", kqstate);
		int y,m,d,h,mi,s;    
		Calendar cal=Calendar.getInstance();    
		y=cal.get(Calendar.YEAR);    
		m=cal.get(Calendar.MONTH);    
		m = m+1;
		d=cal.get(Calendar.DATE);    
		h=cal.get(Calendar.HOUR_OF_DAY);    
		mi=cal.get(Calendar.MINUTE);    
		s=cal.get(Calendar.SECOND);    
		System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
		String time = y+"-"+m+"-"+d;
		model.addAttribute("time", time);
		return "gk/Attendance_inputYG";
	}
	//查询所有员工	sql
	@RequestMapping("queryAllYuanGongkq")
	@ResponseBody
	public List<CqjStaff> queryAllYuanGongkq(){
		return cqjStaffService.queryAllYuanGong();
	}
	//新增员工当天考勤	sql
	@RequestMapping("insertYuanGongKaoQin")
	@ResponseBody
	public int insertYuanGongKaoQin(@RequestBody List<GkKaoqin> list) {
		return gkKaoQinService.insertYuanGongKaoQin(list);
	}
	
	
	
	//去录入班级考勤页面	sql
	@RequestMapping("toAttendance_input")
	public String toAttendance_input(Model model,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		List<GkKaoqinState> kqstate = gkKaoqinStateService.queryAllKaoQinState();
		model.addAttribute("kqstate", kqstate);
		model.addAttribute("banjiname",clazzService.queryBanJiByUserid(user.getUserid()));
		int y,m,d,h,mi,s;    
		Calendar cal=Calendar.getInstance();    
		y=cal.get(Calendar.YEAR);    
		m=cal.get(Calendar.MONTH);    
		m = m+1;
		d=cal.get(Calendar.DATE);    
		h=cal.get(Calendar.HOUR_OF_DAY);    
		mi=cal.get(Calendar.MINUTE);    
		s=cal.get(Calendar.SECOND);    
		System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
		String time = y+"-"+m+"-"+d;
		model.addAttribute("time", time);
		return "gk/Attendance_input";
	}
	//通过学生id查询所在班级所有学生     sql
	@RequestMapping("queryTongXueByUserid")
	@ResponseBody
	public List<CqjStudent> queryTongXueByUserid(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
	
		return cqjStudentService.queryTongXueByUserid(user.getUserid());
	}
	//新增班级当天考勤    sql 
	@RequestMapping(value="insertBanJiKaoQin",produces="application/json")
	@ResponseBody
	public int insertBanJiKaoQin(@RequestBody List<GkKaoqin> list,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		Clazz ss = clazzService.queryBanJiByUserid(user.getUserid());
		return gkKaoQinService.insertBanJiKaoQin(list,ss.getId(),ss.getGid());
	}
	//判断是否已经考勤    sql
	@RequestMapping("queryKaoQinPanDuan")
	@ResponseBody
	public int queryKaoQinPanDuan(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		GkKaoqin kq = gkKaoQinService.queryKaoQinPanDuan(user.getUserid());
		if(kq == null) {
			return 0;
		}else {
			return 1;
		}
	}
	//修改班级当天考勤状态   sql
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
	//去我的访谈    sql
	@RequestMapping("goMyFangTan")
	public String goMyFangTan() {
		return "gk/Fill_interview";
	}
	//查询未完成的访谈（个人），别人发起    sql 
	@RequestMapping("queryFangTanByWWCB")
	@ResponseBody
	public List<GkInterview> queryFangTanByWWCB(HttpSession session,Model model){
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByWWCB(user.getUserid());
	}
	//查询已完成的访谈（个人,别人发起）   sql
	@RequestMapping("queryFangTanByYWCB")
	@ResponseBody
	public List<GkInterview> queryFangTanByYWCB(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByYWCB(user.getUserid());
	}
	//查询未完成的访谈（个人），我发起    sql 
	@RequestMapping("queryFangTanByWWCW")
	@ResponseBody
	public List<GkInterview> queryFangTanByWWCW(HttpSession session,Model model){
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByWWCW(user.getUserid());
	}
	//查询已完成的访谈（个人,我发起）   sql
	@RequestMapping("queryFangTanByYWCW")
	@ResponseBody
	public List<GkInterview> queryFangTanByYWCW(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		return gkFangTanService.queryFangTanByYWCW(user.getUserid());
	}
	
	
	//完善访谈   sql
	@RequestMapping("updateFangTanWS")
	public void updateFangTanWS(Integer ftId,String ftObjectExplain) {
		gkFangTanService.updateFangTanWS(ftId, ftObjectExplain);
	}
	//查询所有访谈   sql
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
	//去访谈页面  sql
	@RequestMapping("toInterview")
	public String toInterview() {
		return "gk/Interview";
	}
	//通过访谈id查询访谈详情	sql
	@RequestMapping("queryFangTanDetailsByftid")
	@ResponseBody
	public GkInterview queryFangTanDetailsByftid(Integer ftId) {
		return gkFangTanService.queryFangTanDetailsByftid(ftId);
	}
	//通过访谈id删除访谈	sql
	@RequestMapping("deleteFangTanByftId")
	@ResponseBody
	public int deleteFangTanByftId(int[] shuzu,HttpSession session) {
		return gkFangTanService.deleteFangTanByftId(shuzu);
	}
	//去新增访谈  sql
	@RequestMapping("toNew_interview")
	public String toNew_interview(Model model,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		model.addAttribute("user", user);
		return "gk/New_interview";
	}
	//新增访谈   sql
	@RequestMapping(value="insertFangTan")
	@ResponseBody
	public int insertFangTan(@RequestBody GkInterview ft) {
		return gkFangTanService.insertFangTan(ft);
	}
	//查询所有学生（按姓名模糊查）   sql
	@RequestMapping("queryAllXueSheng")
	@ResponseBody
	public List<GkInterview> queryAllXueSheng(@Param(value="name")String name){
		return gkFangTanService.queryAllXueSheng(name);
	}
	//查询所有家长（按姓名模糊查）   sql
	@RequestMapping("queryAllJiaZhang")
	@ResponseBody
	public List<GkInterview> queryAllJiaZhang(String name){
		return gkFangTanService.queryAllJiaZhang(name);
	}
	//查询所有员工（按姓名模糊查）	sql
	@RequestMapping("queryAllYuanGong")
	@ResponseBody
	public List<GkInterview> queryAllYuanGong(String name){
		return gkFangTanService.queryAllYuanGong(name);
	}
}
