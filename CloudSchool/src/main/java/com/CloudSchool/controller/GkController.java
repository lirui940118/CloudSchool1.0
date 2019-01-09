package com.CloudSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/uuu")
public class GkController {
	@RequestMapping("/kkk")
	@ResponseBody
	public String kkk() {
		return "gk";
	}
	@RequestMapping("/iii")
	public String iii() {
		return "index";
	}
}
