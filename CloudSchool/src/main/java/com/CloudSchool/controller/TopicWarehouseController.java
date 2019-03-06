package com.CloudSchool.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.LrKnowledagepoint;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Topictype;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.Workmould;
import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.ZzySection;
import com.CloudSchool.domain.zjfvo.TeacherAdminStu;
import com.CloudSchool.domain.zjfvo.TopicParam;
import com.CloudSchool.domain.zjfvo.WorkPublishParam;
import com.CloudSchool.service.ClazzcourseteacherService;
import com.CloudSchool.service.LrKnowledagepointService;
import com.CloudSchool.service.TopicService;
import com.CloudSchool.service.TopicTypeService;
import com.CloudSchool.service.WorkMouldService;
import com.CloudSchool.service.WorkinStanceService;
import com.CloudSchool.service.ZzyCourseService;
import com.CloudSchool.service.ZzySectionService;
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
	
	@Autowired
	ZzyCourseService zzyCourseService;
	
	@Autowired
	ZzySectionService zzySectionService;
	
	@Autowired
	LrKnowledagepointService lrKnowledagepointService;
	// 添加题目
	@RequestMapping("addTopic")
	@ResponseBody
	public int addTopic(String str,MultipartFile file,HttpSession session) {
		TopicWithBLOBs Topic=JSON.parseObject(str, TopicWithBLOBs.class);	//题目复杂参数
		CqjUser user=(CqjUser)session.getAttribute("user");
		Topic.setUid(user.getUsertypeid());
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
	public PageBean conditionsQueryTopci(String str,Integer cur){
		TopicParam obj=new TopicParam();
		if(str!=null) {
			obj=JSON.parseObject(str, TopicParam.class);
		}
		
		System.out.println(JSON.toJSONString(obj));
		if(cur==null) {
			cur=1;
		}
		Integer pagesize=10;
		return topicService.conditionsQueryTopci(obj,cur,pagesize);
	}
	
	
	//作业模板生成
	@RequestMapping("workTemplateCreate")
	@ResponseBody
	public int workTemplateCreate(@RequestBody Workmould obj,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		obj.setTid(user.getUsertypeid());
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
	public PageBean queryByTidMould(Integer tid,Integer cur,HttpSession session) {
		Integer pagesize=2;
		if(cur==null) {
			cur=1;
		}
		CqjUser user=(CqjUser)session.getAttribute("user");
		tid=user.getUsertypeid();
		return workMouldService.queryByTidMould(tid, cur, pagesize);
	}
	
	//查询到教员管理的班级
	@RequestMapping("queryByTidResultClass")
	@ResponseBody
	public List<Clazzcourseteacher> queryByTidResultClass(Integer tid,HttpSession session){
		CqjUser user=(CqjUser)session.getAttribute("user");
		tid=user.getUsertypeid();
		System.out.println(tid);
		return clazzcourseteacherService.queryByTidResultClass(tid);
	}
	
	
	//根据老师查询到管理的班级所有的学生
	@RequestMapping("queryByTidAdminStuAll")
	@ResponseBody
	public List<TeacherAdminStu> queryByTidAdminStuAll(Integer tid,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		tid=user.getUsertypeid();
		return workMouldService.queryByTidAdminStuAll(tid);
	}
	@RequestMapping("WorkPublishParam")
	@ResponseBody
	public int publishWork(@RequestBody WorkPublishParam obj,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		Integer tid=user.getUsertypeid();
		obj.getObj().setTid(tid);
		System.out.println(JSON.toJSONString(obj));
		return workinStanceService.publishWork(obj);
	}
	
	//根据年级查询课程
	@RequestMapping("queryBygid")
	@ResponseBody
	public List<ZzyCourse> queryBygid(Integer cid){
		return zzyCourseService.queryBygid(cid);
	}
	
	//根据课程查询章节
	@RequestMapping("queryBycid")
	@ResponseBody
	public List<ZzySection> queryBycid(Integer cid){
		return zzySectionService.queryBycid(cid);
	}
	
	@RequestMapping("queryCourseAll")
	@ResponseBody
	public List<ZzyCourse> queryCourseAll(){
		return zzyCourseService.queryCourseAll();
	}
	
	
	@RequestMapping("queryPoint")
	@ResponseBody
	public List<LrKnowledagepoint> queryPoint(Integer sid){
		return lrKnowledagepointService.queryBySid(sid);
	}
	
	
	//跳转到添加知识点
	@RequestMapping("toknowledge")
	public String toknowledge() {
		return "zjf/test/knowledge";
	}
	
	@RequestMapping("queryAllSection")
	@ResponseBody
	public List<ZzySection> queryAllSection(){
		return zzySectionService.queryAllSection();
	}
	
	
	//添加知识点
	@RequestMapping("insertObj")
	@ResponseBody
	public int insertObj(LrKnowledagepoint obj,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		obj.setUid(user.getUsertypeid());
		return lrKnowledagepointService.insertObj(obj);
	}

	
}
