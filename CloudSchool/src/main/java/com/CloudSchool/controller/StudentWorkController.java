package com.CloudSchool.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.service.WorkinStanceService;
import com.CloudSchool.service.WtrecordService;
import com.alibaba.fastjson.JSON;
@Controller
@RequestMapping("StudentWork")
public class StudentWorkController {
	
	@Autowired
	WorkinStanceService workinStanceService;
	@Autowired
	WtrecordService wtrecordService;
	@RequestMapping("studentWork")
	public String toStudentWork(Integer wid,HttpSession session) {
		session.setAttribute("studentworkid", wid);
		return "zjf/student/studentWork";
	}
	@RequestMapping(value="fileUploads",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String fileUploads(MultipartFile file) {
		/*Response.setCharacterEncoding("text/html;charset=utf-8");
		Response.setCharacterEncoding("text/html;charset=utf-8");*/
		UUID u = UUID.randomUUID();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		// 文件名称
		String filename = df.format(new Date()).toString().replace("-", "").replace(":", "").replace(" ", "")
				+ u.toString().substring(0, 8);
		File f = new File("E:\\img\\word");
		if (!f.exists()) {
			f.mkdirs();
		} else {
			f.delete();
		}
		try {
			String name=filename + file.getOriginalFilename();
			file.transferTo(new File(f, filename + file.getOriginalFilename()));
			return name;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("queryStudentWork")
	@ResponseBody
	public Workinstance queryStudentWork(Integer sid,HttpSession session) {
		sid=1;
		Integer wid=(Integer)session.getAttribute("studentworkid");
		return workinStanceService.queryStudentWork(wid, sid);
	}
	
	//关闭浏览器存储答题情况
	@RequestMapping("pageSaveClose")
	@ResponseBody
	public int pageSaveClose(@RequestBody Workinstance obj) {
		/*System.out.println(JSON.toJSONString(obj));*/
		return  wtrecordService.pageSaveClose(obj);
	}
	
	//学生交作业
	@RequestMapping("studentPublishWork")
	@ResponseBody
	public int studentPublishWork(@RequestBody Workinstance obj) {
		return wtrecordService.studentPublishWork(obj);
	}
}
