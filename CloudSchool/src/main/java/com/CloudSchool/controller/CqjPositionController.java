package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("getPosition")
	@ResponseBody
	public List<CqjPosition> getPosition(){
		return cps.qeuryAllposition();
	}
	@RequestMapping("update")
	@ResponseBody
	public void updatePositionModule(Integer positionid,String modules) {
		String[] result=new String[] {} ;
		if(modules.length()>0) {
			modules=modules.substring(0, modules.length() -1);
			result= modules.split(",");
		}
		cps.updatePositionAndModule(positionid,result);
		System.out.println("进入updatePositionModule"+modules);
	}
}
