package com.CloudSchool.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Topictype;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.Workmould;
import com.CloudSchool.domain.zjfvo.TeacherAdminStu;
import com.CloudSchool.domain.zjfvo.WorkPublishParam;
import com.CloudSchool.service.ClazzcourseteacherService;
import com.CloudSchool.service.TopicService;
import com.CloudSchool.service.TopicTypeService;
import com.CloudSchool.service.WorkMouldService;
import com.CloudSchool.service.WorkinStanceService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("topicWarehouseController")
public class TopicWarehouseController {
	@Autowired
	TopicService topicService;
	@Autowired
	TopicTypeService topicTypeService;
	@Autowired
	WorkMouldService workMouldService;
	
	@Autowired
	ClazzcourseteacherService clazzcourseteacherService;
	
	@Autowired
	WorkinStanceService workinStanceService;
	// 添加题目
	@RequestMapping("addTopic")
	@ResponseBody
	public int addTopic(String str,MultipartFile file) {
		TopicWithBLOBs Topic=JSON.parseObject(str, TopicWithBLOBs.class);	//题目复杂参数
		return topicService.insertSelective(Topic,file);
	}
	//跳转到题目添加
	@RequestMapping("TopageTopickAdd")
	public String TopageTopickAdd() {
		return "zjf/topickadd";
	}
 
	/*@RequestMapping("test")
	@ResponseBody
	public int test(MultipartFile file) {
		File f = new File("E:\\img\\word","c");
		if (!f.exists()) {
			f.mkdirs();
		} else {
			f.delete();
		}
		try {
			file.transferTo(new File("E:\\img\\word\\word"+file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}*/
	
	//跳转到布置作业页面
	@RequestMapping("toAppearTopicWork")
	public String toAppearTopicWork() {
		return "zjf/appearTopicWork";
	}
	
	//查询题目类型
	@RequestMapping("queryAllTopicType")
	@ResponseBody
	public List<Topictype> queryAllTopicType(){
		return topicTypeService.queryTopicTypeAll();
	}
	
	//根据条件查询题目(多条件)
	@RequestMapping("conditionsQueryTopci")
	@ResponseBody
	public PageBean conditionsQueryTopci(Topic obj,Integer cur){
		if(cur==null) {
			cur=1;
		}
		Integer pagesize=2;
		return topicService.conditionsQueryTopci(obj,cur,pagesize);
	}
	
	
	//作业模板生成
	@RequestMapping("workTemplateCreate")
	@ResponseBody
	public int workTemplateCreate(@RequestBody Workmould obj) {
		return topicService.workTemplateCreate(obj);
	}
	
	
	//跳转到发布作业
	@RequestMapping("toPublishWork")
	public String toPublishWork() {
		return "zjf/publishWork";
	}
	
	//根据教员ID查询作业模板
	@RequestMapping("queryByTidMould")
	@ResponseBody
	public PageBean queryByTidMould(Integer tid,Integer cur) {
		Integer pagesize=2;
		if(cur==null) {
			cur=1;
		}
		return workMouldService.queryByTidMould(tid, cur, pagesize);
	}
	
	//查询到教员管理的班级
	@RequestMapping("queryByTidResultClass")
	@ResponseBody
	public List<Clazzcourseteacher> queryByTidResultClass(Integer tid){
		return clazzcourseteacherService.queryByTidResultClass(tid);
	}
	
	
	//根据老师查询到管理的班级所有的学生
	@RequestMapping("queryByTidAdminStuAll")
	@ResponseBody
	public List<TeacherAdminStu> queryByTidAdminStuAll(Integer tid) {
		// TODO Auto-generated method stub
		return workMouldService.queryByTidAdminStuAll(tid);
	}
	@RequestMapping("WorkPublishParam")
	@ResponseBody
	public int publishWork(@RequestBody WorkPublishParam obj) {
		return workinStanceService.publishWork(obj);
	}
	
	@RequestMapping("queryTopicById")
	@ResponseBody
	public TopicWithBLOBs queryTopicById(Integer id) {
		return topicService.queryTopicById(id);
	}
	
	@RequestMapping("toTopicShow")
	public String toTopicShow() {
		return "zjf/topicShow";
	}
	
	
}
