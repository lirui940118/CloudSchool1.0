package com.CloudSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.Workinstance;
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

	// 跳转到作业详情页面
	@RequestMapping("toWorkInfo")
	public String toWorkInfo(Integer id,HttpSession session) {
		session.setAttribute("zjf_toWorkInfoid", id);
		return "zjf/workInfo";
	}

	// 跳转到作业详情页面
	@RequestMapping("/as")
	@ResponseBody
	public String aaaa() {
		// dynamicTaskJobs.addTaskTimerJob(addScoreTaskJob, "*/5 * * * * *");
		addScoreTaskJob.zzz(4, 5);
		dynamicTaskJobs.addTaskJob(addScoreTaskJob, "2019-01-19 10:25:20");
		return "zj";
	}
	
	@RequestMapping("queryWorkStuInfo")
	@ResponseBody
	public Workinstance queryWorkStuInfo(Integer id,HttpSession session) {
		id=(Integer)session.getAttribute("zjf_toWorkInfoid");
		return workinStanceService.queryWorkStuInfo(id);
	}
}
