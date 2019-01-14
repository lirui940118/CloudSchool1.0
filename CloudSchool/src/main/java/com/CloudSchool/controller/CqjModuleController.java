package com.CloudSchool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjRole;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjMoudelService;
import com.CloudSchool.service.CqjRoleService;

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
	
	@RequestMapping("getPositionInfoModule")
	@ResponseBody
	public List<CqjModule> getPositionInfoModule(Integer positionid) {
		List<CqjModule> c=cms.queryAllInfoModule(positionid);
		return c;
	}
	
	@RequestMapping("getRoleAllModule")
	@ResponseBody
	public List<CqjModule> getRoleAllModule(Integer roleid) {
		List<CqjModule> c=cms.queryAllModule(roleid);
		return c;
	}
	
	@RequestMapping("getInfoModule")
	@ResponseBody
	public List<CqjModule> getInfoModule(HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		return cms.queryInfoModule(user.getPositionid());
	}
	
}
