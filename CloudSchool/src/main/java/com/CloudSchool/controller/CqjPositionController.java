package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjPositionService;

@Controller
@RequestMapping("position")
public class CqjPositionController {
	@Autowired
	CqjPositionService cps;
	
	
	@RequestMapping("html")
	public String goHtml(){
		return "cqj_setting/setting-position";
	}
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String goAdd(){
		return "cqj_setting/setting-position_insertPosition";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public int addPosition(CqjPosition p,String modules ,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		String[] result=new String[] {} ;
		if(modules.length()>0) {
			modules=modules.substring(0, modules.length() -1);
			result= modules.split(",");
		}
		p.setUid(user.getUid());
		return cps.addPosition(p, result);
	}
	
	@RequestMapping("getPosition")
	@ResponseBody
	public List<CqjPosition> getPosition(){
		return cps.qeuryAllposition();
	}
	@RequestMapping("update")
	@ResponseBody
	public int updatePositionModule(Integer positionid,String modules) {
		String[] result=new String[] {} ;
		if(modules.length()>0) {
			modules=modules.substring(0, modules.length() -1);
			result= modules.split(",");
		}
		return cps.updatePositionAndModule(positionid,result);
	}
	
	
}
