package com.CloudSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Message;
import com.CloudSchool.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	MessageService ms;
	@RequestMapping("/message")
	public String toMessage() {
		System.out.println("1111111111111111111111111111111111");
		return "tzx/message";
	}
	@ResponseBody
	@RequestMapping("/senderMessage")
	public int senderMessage(HttpSession session,Message m) {
		CqjUser u=(CqjUser) session.getAttribute("user");
		System.out.println("用户-发送消息："+u.getUserid());
		m.setSender(u.getUserid());
		return ms.insert(m);
	}
}
