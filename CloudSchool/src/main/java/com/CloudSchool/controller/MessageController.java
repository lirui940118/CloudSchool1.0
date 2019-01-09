package com.CloudSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
	@RequestMapping("/message")
	public String toMessage() {
		System.out.println("1111111111111111111111111111111111");
		return "tzx/message";
	}
}
