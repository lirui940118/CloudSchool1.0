package com.CloudSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoticeController {
	@RequestMapping(value="/addnotice" ,method=RequestMethod.GET)
	public String toAddNotice() {
		System.out.println("跳转页面-添加通知");
		return "tzx/addnotice";
	}
	@ResponseBody
	@RequestMapping(value="/addnotice" ,method=RequestMethod.POST)
	public String addNotice() {
		System.out.println("新增-添加通知");
		return "添加通知成功！";
	}
	@RequestMapping("/notice")
	public String toNotice() {
		System.out.println("跳转页面-通知列表");
		return "tzx/notice";
	}
	@ResponseBody
	@RequestMapping("/noticeList")
	public String NoticeList() {
		System.out.println("查询-通知列表");
		return "通知列表";
	}
	@RequestMapping("/noticeDetail")
	public String toNoticeDetail() {
		System.out.println("跳转页面-通知详情");
		return "tzx/noticeDetail";
	}
	@ResponseBody
	@RequestMapping("/noticeInfo")
	public String noticeInfo() {
		System.out.println("查询-通知详情");
		return "通知详情";
	}
}
