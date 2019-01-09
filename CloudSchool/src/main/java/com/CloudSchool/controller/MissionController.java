package com.CloudSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mission")
public class MissionController {
	@RequestMapping("/aaa")
	public String aaa() {
		return "index";
	}
	@RequestMapping("/bbb")
	@ResponseBody
	public String bbb() {
		return "{'name':'czw'}";
	}
}
