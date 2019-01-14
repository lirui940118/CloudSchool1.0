package com.CloudSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.service.CqjUserService;
import com.CloudSchool.service.GkFangTanService;

@Controller
@RequestMapping("/GK/")
public class GkController {
	
	//访谈
	@Autowired
	GkFangTanService gkFangTanService;
	
	//查询所有访谈
	@RequestMapping("queryAllFangTan")
	@ResponseBody
	public GkPageBean<GkInterview> queryAllFangTan(GkFangTan ft){
		System.out.println(ft.getCurrentPage());
		System.out.println(ft.getPageSize());
		if(ft.getCurrentPage() == null) {
			ft.setCurrentPage(1);
		}
		if(ft.getPageSize() == null) {
			ft.setPageSize(1);
		}
		System.out.println(ft.getCurrentPage());
		System.out.println(ft.getPageSize());
		GkPageBean<GkInterview> asdf = gkFangTanService.queryAllFangTan(ft);
		System.out.println("结果："+asdf);
		return gkFangTanService.queryAllFangTan(ft);
	}
	
	//去访谈页面
	@RequestMapping("toInterview")
	public String toInterview() {
		return "gk/Interview";
	}
	
	//通过访谈id查询访谈详情
	@RequestMapping()
	@ResponseBody
	public GkInterview queryFangTanDetailsByftid(Integer ftid) {
		
		return null;
	}
}
