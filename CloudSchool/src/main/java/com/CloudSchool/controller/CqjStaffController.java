package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.service.CqjStaffService;

@Controller
@RequestMapping("staff")
public class CqjStaffController {
	@Autowired
	CqjStaffService css;
	
	@RequestMapping("goAddStaff")
	public String goLogin(HttpSession session) {
		return "cqj_setting/staff_insert";
	}
	@RequestMapping("addStaffs")
	@ResponseBody
	public int addStaffs(@RequestBody List<CqjStaff> list) {
		css.addStaffs(list);
		return 0;
	}
}
