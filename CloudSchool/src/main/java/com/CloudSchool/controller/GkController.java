package com.CloudSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.service.GkFangTanService;

@Controller
@RequestMapping("/GK/")
public class GkController {
	
	@Autowired
	GkFangTanService gkFangTanService;
	
	//查询所有访谈
	@RequestMapping("queryAllFangTan")
	@ResponseBody
	public GkPageBean<GkInterview> queryAllFangTan(Integer currentPage,Integer pageSize){
		if(currentPage == null) {
			currentPage = 1;
		}
		if(pageSize == null) {
			pageSize = 1;
		}
		return gkFangTanService.queryAllFangTan(currentPage, pageSize);
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
