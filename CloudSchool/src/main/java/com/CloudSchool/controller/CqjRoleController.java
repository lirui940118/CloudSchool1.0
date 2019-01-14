package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjRole;
import com.CloudSchool.service.CqjRoleService;

@Controller
@RequestMapping("role")
public class CqjRoleController {
	@Autowired
	CqjRoleService crs;
	
	@RequestMapping("getRole")
	@ResponseBody
	public List<CqjRole> getRole(){
		return crs.queryAllRole();
	}
	
	@RequestMapping("update")
	@ResponseBody
	public void updatePositionModule(Integer roleid,String modules) {
		String[] result=new String[] {} ;
		if(modules.length()>0) {
			modules=modules.substring(0, modules.length() -1);
			result= modules.split(",");
		}
		crs.updateRoleAndModule(roleid, result);
		System.out.println("进入updatePositionModule"+modules);
	}
	
	
	
}
