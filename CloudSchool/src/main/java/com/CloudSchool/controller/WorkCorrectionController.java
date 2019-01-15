package com.CloudSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.service.WorkinStanceService;

@Controller
@RequestMapping("WorkCorrection")
public class WorkCorrectionController {
	@Autowired
	WorkinStanceService workinStanceService;
	
	/*跳转到作业批改*/
	@RequestMapping("toWorkCorrectionIndex")
	public String toWorkCorrectionIndex() {
		return "zjf/workCorrectInfo";
	}
	
	/*根据教师id查询发布的作业 */
	@RequestMapping("queryPublishWorkByTid")
	@ResponseBody
	public PageBean queryPublishWorkByTid(Integer tid, Integer wStatus,Integer pageSize,Integer cur) {
		if(pageSize==null) {
			pageSize=2;
		}
		return workinStanceService.queryPublishWorkByTid(tid, wStatus, pageSize, cur);
	}

}
