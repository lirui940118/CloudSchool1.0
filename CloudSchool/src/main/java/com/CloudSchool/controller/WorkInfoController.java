package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.zjfvo.WorkinstanceInfo;
import com.CloudSchool.service.ParticipationworkstuService;
import com.CloudSchool.service.WorkinStanceService;
import com.CloudSchool.timer.AddMissionTaskJob;
import com.CloudSchool.timer.AddScoreTaskJob;
import com.CloudSchool.timer.DynamicTaskJobs;

@Controller
@RequestMapping("WorkInfo")
public class WorkInfoController {
	@Autowired
	DynamicTaskJobs dynamicTaskJobs;
	@Autowired
	AddScoreTaskJob addScoreTaskJob;

	@Autowired
	WorkinStanceService workinStanceService;
	
	@Autowired
	ParticipationworkstuService participationworkstuService;
	// 跳转到作业详情页面
	@RequestMapping("toWorkInfo")
	public String toWorkInfo(Integer cid,Integer wid,HttpSession session) {
		session.setAttribute("zjf_toWorkInfocid", cid);
		session.setAttribute("zjf_toWorkInfowid", wid);
		return "zjf/workInfo";
	}

	// 跳转到作业详情页面
	@RequestMapping("/as")
	@ResponseBody
	public String aaaa(String time) {
		addScoreTaskJob.zzz(4, 5);
		dynamicTaskJobs.addTaskJob(addScoreTaskJob, time);
		return "zj";
	}
	
	@RequestMapping("queryWorkStuInfo")
	@ResponseBody
	public List<WorkinstanceInfo> queryWorkStuInfo(Integer cid,Integer wid,HttpSession session) {
		cid=(Integer)session.getAttribute("zjf_toWorkInfocid");
		wid=(Integer)session.getAttribute("zjf_toWorkInfowid");
		return participationworkstuService.queryByCidAndWidShowInfo(cid, wid);
	}
}
