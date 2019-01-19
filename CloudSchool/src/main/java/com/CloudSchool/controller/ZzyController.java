package com.CloudSchool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.dao.ZzyClassCommitteeMapper;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.Clazzstudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.ZzyClassPosition;
import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.ZzyMajor;
import com.CloudSchool.domain.ZzyVersion;
import com.CloudSchool.service.ClassStudentService;
import com.CloudSchool.service.ClazzService;
import com.CloudSchool.service.ZzyClassPositionService;
import com.CloudSchool.service.ZzyCourseService;
import com.CloudSchool.service.ZzyGradeService;
import com.CloudSchool.service.ZzyMajorService;
import com.CloudSchool.service.ZzyVersionService;

@Controller
@RequestMapping("zzy")
public class ZzyController {
	@Autowired
	ZzyVersionService vers;
	
	@Autowired
	ZzyMajorService majs;
	
	@Autowired
	ZzyGradeService gras;
	
	@Autowired
	ZzyCourseService cous;
	
	@Autowired
	ClazzService clas;
	
	@Autowired
	ClassStudentService clss;
	
	@Autowired
	ZzyClassPositionService poss;
	
	@Autowired
	ZzyClassCommitteeMapper coms;
	
	List<ZzyClassPosition> deletelist=null;
	
	//查询所有版本
	@RequestMapping("/queryAllversion")
	public String queryAllversion(Model model) {
		List<ZzyVersion> list = vers.queryAll();
		model.addAttribute("list", list);
		return "zzy/version.html";
	}
	
	//跳转新增版本页面
	@RequestMapping("/addVersion")
	public String addVersion() {
		return "zzy/addversion.html";
	}
	
	//添加版本方法
	@RequestMapping("/insertVersion")
	@ResponseBody
	public int insertVersion(@RequestBody ZzyVersion version) {
		vers.insert(version);
		return 1;
	}
	
	//添加专业方法
	@RequestMapping("/insertMajor")
	@ResponseBody
	public int insertMajor(@RequestBody List<ZzyMajor> major) {
		majs.insertList(major);
		return 1;
	}
	
	//跳转新增课程界面
	@RequestMapping("/addCourse")
	public String addCourse() {
		return "zzy/addcourse.html";
	}
	
	//使用Ajax查询所有版本
	@RequestMapping("/AjaxqueryAllVersion")
	@ResponseBody
	public List<ZzyVersion> AjaxqueryAllVersion(){
		return vers.queryAll();
	}
	
	//使用Ajax查询所有年级
	@RequestMapping("queryGradeAll")
	@ResponseBody
	public List<ZzyGrade> queryGradeAll(){
		return gras.queryAll();
	}
	
	//使用Ajax根据版本id查询所属年级
	@RequestMapping("/queryByvid")
	@ResponseBody
	public List<ZzyGrade> queryByvid(Integer vid){
		return gras.queryByvid(vid);
	}
	
	//查询所有专业
	@RequestMapping("/queryMajorAll")
	@ResponseBody
	public List<ZzyMajor> queryMajorAll(){
		return majs.queryAll();
	}
	
	//添加课程以及循环添加章节
	@RequestMapping("/insertCourse")
	@ResponseBody
	public int insertCourse(@RequestBody ZzyCourse course) {
		cous.insert(course);
		return 1;
	}
	
	//进入概览图
	@RequestMapping("/overview")
	public String overview(Integer vid,Model model) {
		model.addAttribute("vid", vid);
		return "zzy/overview.html";
	}
	
	//一对多查询版本以及版本里面的年级
	@RequestMapping("/VerAndGrade")
	@ResponseBody
	public ZzyVersion VerAndGrade(Integer vid) {
		return vers.VerAndGrade(vid); 
	}
	
	//一对多查询版本以及版本里面的年级,年级里面的课程,课程里面的章节
	@RequestMapping("/VerAndGrade2")
	@ResponseBody
	public ZzyVersion VerAndGrade2(Integer vid) {
		System.out.println(vid);
		return vers.VerAndGrade2(vid); 
	}
	
	//根据登录的用户获取与用户相关的班级
	@RequestMapping("/zz")
	@ResponseBody
	public List<Clazz> zz(HttpSession session) {
//		CqjUser user=(CqjUser)session.getAttribute("user");
//		user.getClazzidsList();
		List<String> list = new ArrayList<String>();
		list.add("4");
		list.add("5");
		list.add("6");
		List<Clazz> list2=clas.queryListid(list);
		return list2;
	}
	
	//进入班级管理页面
	@RequestMapping("classManage")
	public String classManage() {
		return "zzy/class.html";
	}
	
	//进入班级详情页面
	@RequestMapping("class_details")
	public String class_details(Integer id,Model model) {
		model.addAttribute("id", id);
		return "zzy/class_details.html";
	}
	
	//使用Ajax根据班级id查询班级详情
	@RequestMapping("queryByclazzid")
	@ResponseBody
	public Clazz queryByclazzid(Integer id) {
		System.out.println(id);
		return clas.queryByid(id);
	}
	
	//使用Ajax根据班级id查询班级学员
	@RequestMapping("queryByMo")
	@ResponseBody
	public List<Clazzstudent> queryByMo(Integer id){
		return clss.queryByMo(id);
	}
	
	
	//使用Ajax添加职位以及班委
	@RequestMapping("insertComAndPos")
	@ResponseBody
	public int insertComAndPos(@RequestBody List<ZzyClassPosition> comlist) {
		for (ZzyClassPosition zzyClassPosition : deletelist) {
			poss.deleteBypid(zzyClassPosition.getPid());
			coms.delteByccid(zzyClassPosition.getCom().getCcid());
		}
		poss.insertPos(comlist);
		return 1;
	}
	
	
	//根据班级id查询班级所有的职位
	@RequestMapping("queryByclid")
	@ResponseBody
	public List<ZzyClassPosition> queryByclid(Integer id){
		deletelist=poss.queryByclid(id);
		return deletelist;
	}
	
	
	//根据班级id查询所有从这个班级游离出去的学员 以及他们现在所在的班级
	@RequestMapping("queryZc")
	@ResponseBody
	public List<Clazzstudent> queryZc(Integer id){
		return clss.queryZc(id);
	}
	
	//查询所有状态为游离未分配的学员
	@RequestMapping("queryBystatus")
	@ResponseBody
	public List<Clazzstudent> queryBystatus(){
		return clss.queryBystatus();
	}
	
	
	//添加游离池中的学员加入本班级
	@RequestMapping("addYl")
	@ResponseBody
	public int addYl(@RequestBody List<Clazzstudent> list){
		for (Clazzstudent clazzstudent : list) {
			clss.insertOne(clazzstudent);
			clss.updateByid(clazzstudent);
		}
		return  1;
	}
	
	
	
	
}
