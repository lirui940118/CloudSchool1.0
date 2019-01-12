package com.CloudSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.service.CqjMoudelService;

@Controller
@RequestMapping("module")
public class CqjModuleController {
	@Autowired
	CqjMoudelService cms;

	@RequestMapping("getModule")
	@ResponseBody
	public List<CqjModule> getModule(Integer roleid) {
		return cms.queryAllModule(roleid);
	}
	
	@RequestMapping("getInfoModule")
	@ResponseBody
	public List<CqjModule> getInfoModule(Integer positionid) {
		List<CqjModule> c=cms.queryAllModule(positionid);
		return c;
	}
}
