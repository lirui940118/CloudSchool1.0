package com.CloudSchool.controller;

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

import com.CloudSchool.domain.CqjParents;
import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.service.CqjPositionService;
import com.CloudSchool.service.CqjUserService;
import com.CloudSchool.service.GkFangTanService;
import com.CloudSchool.service.GkKaoQinService;

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
	
	//去员工考勤页面
	@RequestMapping("toEmployee_attendance")
	public String toEmployee_attendance(Model model) {
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
	
	
	
	
	
	//查询未完成的访谈
	@RequestMapping("queryFangTanByWWC")
	public String queryFangTanByWWC(HttpSession session,Model model){
		CqjUser user=(CqjUser)session.getAttribute("user");
		model.addAttribute("fangtan", gkFangTanService.queryFangTanByWWC(user.getUserid()));
		return "gk/Fill_interview";
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
		System.out.println(ft);
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
