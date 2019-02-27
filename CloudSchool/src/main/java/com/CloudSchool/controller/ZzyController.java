package com.CloudSchool.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.dao.ClassroomMapper;
import com.CloudSchool.dao.ZzyClassCommitteeMapper;
import com.CloudSchool.dao.ZzyRealtimeClassroomMapper;
import com.CloudSchool.domain.Classroom;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.Clazzstudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.ZzyClassPosition;
import com.CloudSchool.domain.ZzyClassSchedule;
import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.ZzyEventType;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.ZzyMajor;
import com.CloudSchool.domain.ZzyRealtimeClassroom;
import com.CloudSchool.domain.ZzyVersion;
import com.CloudSchool.service.ClassStudentService;
import com.CloudSchool.service.ClassroomService;
import com.CloudSchool.service.ClazzService;
import com.CloudSchool.service.ZzyClassCommitteeService;
import com.CloudSchool.service.ZzyClassPositionService;
import com.CloudSchool.service.ZzyClassScheduleService;
import com.CloudSchool.service.ZzyCourseService;
import com.CloudSchool.service.ZzyGradeService;
import com.CloudSchool.service.ZzyMajorService;
import com.CloudSchool.service.ZzyRealtimeClassroomService;
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
	ZzyClassCommitteeService coms;
	
	@Autowired
	ZzyClassScheduleService csss;
	
	@Autowired
	ClassroomService clr;
	
	@Autowired
	ZzyRealtimeClassroomService realtime;
	
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
	
	//进入自动排课界面
	@RequestMapping("entrancePk")
	public String entrancePk() {
		return "zzy/automatic_arrangement.html";
	}
	
	//点击自动排课按钮
	@RequestMapping("arrangement")
	@ResponseBody
	public int arrangement(String time) throws ParseException {
		//将获取的时间分隔为年 周
		String[] arry=time.split("-W");
		//年
		int year =Integer.parseInt(arry[0]);
		//周
		int week =Integer.parseInt(arry[1]);
		csss.paike(year, week);
		return 1; 
	}
	
	//进入实时课堂
	@RequestMapping("Goshishi")
	public String Goshishi(Integer tid,Model model) {
		tid=3;
		model.addAttribute("tid", tid);
		return "zzy/realTime.html";
	}
	
	@RequestMapping("queryBytidAndtime")
	@ResponseBody
	//Ajax根据当前日期以及当前时间区间和教师id判断该教师该时间段是否有课
	public ZzyClassSchedule queryBytidAndtime(Integer tid) {
		ZzyClassSchedule ss=csss.queryBytidAndtime(tid);
		System.out.println(ss.getCsid());
		return ss; 
	}
	
	
	//Ajax根据班级id查询所有的正常学生对象
	@RequestMapping("queryBystatusAndid")
	@ResponseBody
	public List<Clazzstudent> queryBystatusAndid(Integer cid,Integer tid){
		List<Clazzstudent> list=clss.queryBystatusAndid(cid);
		for (Clazzstudent clazzstudent : list) {
			//获取学员id
			Integer sid=clazzstudent.getStu().getStudentid();
			//查询学员的回答问题总次数
			Integer count=realtime.queryByHuida(tid, sid, cid);
			//回答出来的总次数
			Integer count2=realtime.queryByHuidaTure(tid, sid, cid);
			clazzstudent.getStu().setCount(count);
			clazzstudent.getStu().setCount2(count2);
		}
		return list;
	}
	
	//根据班级id查询班级对象
	@RequestMapping("queryBycid")
	@ResponseBody
	public Clazz queryBycid(Integer id) {
		return clas.queryByid(id);
	}
	
	
	//根据课程id查询课程对象
	@RequestMapping("queryBycourseid")
	@ResponseBody
	public ZzyCourse queryBycourseid(Integer cid) {
	return  cous.queryBycid(cid);
	}
	
	//根据教室id查询教室对象
	@RequestMapping("queryByroomid")
	@ResponseBody
	public Classroom queryByroomid(Integer id) {
		// TODO Auto-generated method stub
		return clr.queryByroomid(id);
	}
	
	//根据教员id查询教员的自定义按钮
	@RequestMapping("queryByuid")
	@ResponseBody
	public List<ZzyEventType> queryByuid(Integer uid){
		
		
		return realtime.queryByuid(uid);
	}
	
	
	//教员添加自定义按钮
	@RequestMapping("insertZidingyi")
	@ResponseBody
	public String insertZidingyi( ZzyEventType shadiao) {
		System.out.println(shadiao.getEvent_name());
		System.out.println(shadiao.getUid());
		System.out.println(shadiao.getReturned_value());
		return realtime.insertZidingyi(shadiao)+"";
	}
	
	
	@RequestMapping("insertTSEid")
	@ResponseBody
	public int insertTSEid(ZzyRealtimeClassroom zzy) {
			realtime.insertTSEid(zzy);
		return 1;
	}
	
	
	@RequestMapping("queryKbBytime")
	@ResponseBody
	public List<Clazz> queryKbBytime(String time) throws ParseException{
		//将获取的时间分隔为年 周
		String[] arry=time.split("-W");
		//年
		int year =Integer.parseInt(arry[0]);
		//周
		int week =Integer.parseInt(arry[1]);
		return csss.queryKbBytime(year, week);
	}
	
	
	@RequestMapping("goaddevent")
	public String goaddevent() {
		return "zzy/addevent.html";
	}
	
	@RequestMapping("zzyGradeAndClazz")
	@ResponseBody
	public List<ZzyGrade> zzyGradeAndClazz(){
		return gras.queryGradeAndClazz();
	}
	
	
	
}
