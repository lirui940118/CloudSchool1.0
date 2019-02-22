package com.CloudSchool.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.Classroom;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.service.ClassroomService;
import com.CloudSchool.service.ClazzService;
import com.CloudSchool.service.CqjStaffService;
import com.CloudSchool.service.TestInstanceService;
import com.CloudSchool.service.TestModuleService;

@Controller
@RequestMapping("TestInstance")
public class TestInstanceController {
	
	@Autowired
	TestInstanceService testInstanceService;
	@Autowired
	TestModuleService testModuleService;
	@Autowired
	ClazzService clazzService;
	@Autowired
	CqjStaffService cqjStaffService;
	//跳转到试卷发布
	@RequestMapping("toTestPublishWork")
	public String toTestPublishWork() {
		return "zjf/test/testPublishWork";
	}
	
	
	/***
	 * 查询所有年级  
	 * @param id
	 * @return
	 */
	@RequestMapping("queryGrade")
	@ResponseBody
	public List<ZzyGrade> queryGrade(String id){
		return testInstanceService.queryGrade(id);
	}
	
	/**
	 * 查询年级  id(标识是否有权限查询所有年级)
	 * @return
	 */
	@RequestMapping("queryClass")
	@ResponseBody
	public Object queryClass(Integer id,Integer sid,Integer cur,Integer pagesize,Integer cid){
		if(pagesize==null) {
			pagesize=2;
		}
		return testInstanceService.queryClass(id, sid,cur,pagesize,cid);
	}
	/**
	 * 根据教师id查询考试模板
	 * @param uid
	 * @param cur
	 * @param pagesize
	 * @return
	 */
	@RequestMapping("queryTestModule")
	@ResponseBody
	public PageBean queryTestModule(Integer uid, Integer cur, Integer pagesize) {
		if(pagesize==null) {
			pagesize=1;
		}
		return testModuleService.queryTestModule(uid, cur, pagesize);
	}
	
	//根据班级班级id查询班级下所有学生
	@RequestMapping("queryByClazzidAllStu")
	@ResponseBody
	public List<Clazz> queryByClazzidAllStu(@RequestBody Integer[] clazzs) {
		return clazzService.queryByClazzidAllStu(clazzs);
	}
	
	//查询到所有这个时间段有空的老师
	@RequestMapping("queryTeachAll")
	@ResponseBody
	public List<CqjStaff> queryTeachAll(String time,Integer status) {
		return cqjStaffService.queryNullTeach(time, status);
	}
	
	//查询到所有这个时间段空教室
	@RequestMapping("queryClassRoomAll")
	@ResponseBody
	public List<Classroom> queryClassRoomAll(String time,Integer status){
		System.out.println();
		return clazzService.queryClassRoomAll(time, status);
	}
}
