package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjRole;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjRoleService;

@Controller
@RequestMapping("role")
public class CqjRoleController {
	@Autowired
	CqjRoleService crs;
	
	
	@RequestMapping("html")
	public String goHtml(){
		return "cqj_setting/setting-role";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String goAdd(){
		return "cqj_setting/setting-role_insertRole";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public int addRole(CqjRole record,String modules,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		String[] result=new String[] {} ;
		if(modules.length()>0) {
			modules=modules.substring(0, modules.length() -1);
			result= modules.split(",");
		}
		record.setUid(user.getUserid().toString());
		return crs.addRole(record, result);
	}
	
	
	
	@RequestMapping("getRole")
	@ResponseBody
	public List<CqjRole> getRole(){
		return crs.queryAllRole();
	}
	
	@RequestMapping("update")
	@ResponseBody
	public int updatePositionModule(Integer roleid,String modules) {
		String[] result=new String[] {} ;
		if(modules.length()>0) {
			modules=modules.substring(0, modules.length() -1);
			result= modules.split(",");
		}
		return crs.updateRoleAndModule(roleid, result);
	}
	
	
	
}
