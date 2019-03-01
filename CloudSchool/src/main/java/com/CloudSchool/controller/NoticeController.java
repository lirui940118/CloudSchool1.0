package com.CloudSchool.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Notice;
import com.CloudSchool.service.NoticeService;
import com.CloudSchool.service.imgcompressService;
import com.alibaba.fastjson.JSONObject;

@Controller
public class NoticeController {
	@Autowired
	NoticeService ns;
	@RequestMapping(value="/addnotice" ,method=RequestMethod.GET)
	public String toAddNotice() {
		System.out.println("跳转页面-添加通知");
		return "tzx/addnotice";
	}
	@ResponseBody
	@RequestMapping(value="/addnotice" ,method=RequestMethod.POST)
	public int addNotice(HttpSession session,Notice n) {
		CqjUser u=(CqjUser)session.getAttribute("user");
		System.out.println("新增-添加通知"+u.getUserid());
		n.setSender(u.getUserid());
		return ns.insert(n);
	}
	@RequestMapping("/notice")
	public String toNotice() {
		System.out.println("跳转页面-通知列表");
		return "tzx/notice";
	}
	@ResponseBody
	@RequestMapping("/noticeList")
	public List<Notice> NoticeList(String time,String str) {
		System.out.println("查询-通知列表");
		return ns.query(time,str);
	}
	@RequestMapping("/noticeDetail")
	public String toNoticeDetail(HttpSession session,int nid) {
		System.out.println("跳转页面-通知详情");
		session.setAttribute("noticeid", nid);
		return "tzx/noticeDetail";
	}
	@ResponseBody
	@RequestMapping("/noticeInfo")
	public Notice noticeInfo(HttpSession session) {
		System.out.println("查询-通知详情");
		int nid=(int) session.getAttribute("noticeid");
		return ns.selectByPrimaryKey(nid);
	}
	/**
	 * 查询个人id、名字信息
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/querpersonerInfo" )
	public CqjUser uinfo(HttpSession session) {//名字存在standby1中
		CqjUser u=(CqjUser)session.getAttribute("user");
		CqjUser u1=ns.querpersonerInfo(u.getUserid());
		System.out.println("查询个人信息："+u.getUserid());
		return u1;
	}
	/**
	 * 查询最新的通知（只查全部中的最新）-tzx首页显示
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLastOneInAll" )
	public Notice queryLastOneInAll() {
		System.out.println("查询最新的通知-首页显示");
		return ns.queryLastOneInAll();
	}
    
}
