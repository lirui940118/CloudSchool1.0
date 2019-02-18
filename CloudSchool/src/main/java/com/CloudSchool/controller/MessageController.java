package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Message;
import com.CloudSchool.handler.MyWebSocketHandler;
import com.CloudSchool.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	CqjUserMapper um;
	@Autowired
	MessageService ms;
	@Autowired
	MyWebSocketHandler handler;
	@RequestMapping(value="/message",method=RequestMethod.GET)
	public String toMessage() {
		System.out.println("跳转-消息");
		return "tzx/message";
	}
	@RequestMapping(value="/message",method=RequestMethod.POST)
	public String Message() {
		System.out.println("查询-消息");
		return "tzx/message";
	}
	@ResponseBody
	@RequestMapping("/senderMessage")
	public String senderMessage(HttpSession session,Message m,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		CqjUser u=(CqjUser) session.getAttribute("user");
		System.out.println("用户-发送消息"+u.getUserid()+">>"+m.getReceiver().length+"个人");
		m.setSender(u.getUserid());
		m.setTitle("好友消息");
		int jg=ms.insert(m);
		String status =null;
		//显示自己发送的信息
		//消息内容前加上聊天对方的id,用于区分多个聊天链接
		status = handler.sendMsg(u.getUserid()+"", u.getUserid()+"-<div class=\"m_message_right\">"+m.getContent()+"</div>");
		//显示好友发来的信息
		for (int receiver : m.getReceiver()) {
			System.out.println("接收人："+receiver);
			status = handler.sendMsg(receiver+"", u.getUserid()+"-<div class=\"m_message_left\">"+m.getContent()+"</div>");
		}
		System.out.println("存储结果:"+jg+"发送结果："+status);
		return status;
	}
	@ResponseBody
	@RequestMapping("/getChatList")
	//userid、username、usertypeid、usertypenub、name、sex、positionid、positionname、url
	public List<CqjUser> getChatList(HttpSession session,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		CqjUser u=(CqjUser) session.getAttribute("user");
		System.out.println("查询聊天列表"+u.getUserid());
		return ms.getChatList(u.getUserid());
	}
	@ResponseBody
	@RequestMapping("/getChatRecord")
	public List<Message> getChatRecord(HttpSession session,HttpServletResponse response,int chatid) {
		response.setCharacterEncoding("utf-8");
		CqjUser u=(CqjUser) session.getAttribute("user");
		System.out.println("查询聊天记录"+chatid);
		return ms.getChatRecord(u.getUserid(),chatid);
	}
	@ResponseBody
	@RequestMapping("/getLoginUserInMessage")
	public CqjUser getLoginUserInMessage(HttpSession session,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		CqjUser u=(CqjUser) session.getAttribute("user");
		System.out.println("当前登录用户信息");
		return u;
	}
	@ResponseBody
	@RequestMapping("/getAllUserList")
	//获取弹窗中绑定的用户信息列表（userid/name/url）分别附带信息职位、班级、家长所属学生
	public List<CqjUser> getAllUserList(HttpSession session,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		CqjUser u=(CqjUser) session.getAttribute("user");
		System.out.println("查询用户列表");
		List<CqjUser> ulist=um.queryStaff();
		ulist.addAll(um.queryStduents());
		ulist.addAll(um.queryParents());
		return ulist;
	}
}
