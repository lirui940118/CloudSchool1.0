package com.CloudSchool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.domain.Clazzstudent;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.StudentVO;
import com.CloudSchool.service.ClazzService;
import com.CloudSchool.service.impl.CqjStudentServiceImpl;
import com.alibaba.fastjson.JSON;

@Controller
public class CreateClazzController {
	@Autowired
	ClazzService cs;
	@Autowired
	ZzyGradeMapper gm;
	@Autowired
	CqjStudentServiceImpl ss;
	@RequestMapping(value="/createClazz",method=RequestMethod.GET)
	public String toCreateClazz() {
		System.out.println("跳转页面-开班");
		return "tzx/createClazz";
	}
	/**
	 * 获取开班可选信息
	 */
	@ResponseBody
	@RequestMapping("/getOptionOfCreateClazz")
	public String getOptionOfCreateClazz() {
		System.out.println("查询-------获取开班可选信息：版本、年级、专业、老师（按课程）、学生");
		return "获取开班可选信息";
	}
	@ResponseBody
	@RequestMapping(value="/craeteClazz",method=RequestMethod.POST)
	public int createClazz(HttpSession session,ClazzInfo c) {
//		c.setId(11);
		System.out.println("开班-新增班级");
		CqjUser u=(CqjUser)session.getAttribute("user");
		if(u!=null) {
			c.setUid(u.getUserid());
		}else {
			c.setUid(0);
		}
		//预添加数据------------
//		c.setCname("AT1717");
//		c.setGid(1);
//		c.setMid(1);
//		c.setCount(30);
//		c.setStatus(0);
//		c.setPc("20190001");
//		c.setSlist(new ArrayList<Clazzstudent>());
//		c.setTlist(new ArrayList<Clazzcourseteacher>());
//		Clazzstudent cls=new Clazzstudent();
//		Clazzstudent cls1=new Clazzstudent();
//		cls.setSid(55);
//		cls1.setSid(66);
//		c.getSlist().add(cls);
//		c.getSlist().add(cls1);
//		Clazzcourseteacher cct=new Clazzcourseteacher();
//		Clazzcourseteacher cct1=new Clazzcourseteacher();
//		cct.setCourseid(11);
//		cct.setTid(22);
//		cct.setIsmaster(1);
//		cct.setIsteacher(0);
//		cct1.setCourseid(12);
//		cct1.setTid(23);
//		cct1.setIsmaster(0);
//		cct1.setIsteacher(1);
//		c.getTlist().add(cct);
//		c.getTlist().add(cct1);
		//预添加数据------------
		return cs.CreateClass(c);
//		return JSON.toJSONString(c);
	}
	@ResponseBody
	@RequestMapping("/createClazz1")
	public void toCreateClazz1(HttpSession session) {
		System.out.println("111111111-------直接调开班方法");
//		CqjUser u=(CqjUser)session.getAttribute("user");
		ClazzInfo c=new ClazzInfo();
		c.setUid(0);
		c.setCname("AT1902");
		c.setSlist(new ArrayList<CqjStudent>());
		CqjStudent s=new CqjStudent();
//		s.setStudentnub("AT190101");
		s.setStudentid(20);
		c.getSlist().add(s);
		CqjStudent s1=new CqjStudent();
//		s1.setStudentnub("AT190102");
		s1.setStudentid(21);
		c.getSlist().add(s1);
		System.out.println(JSON.toJSONString(c));
		createClazz(session,c);
	}
	@ResponseBody
	@RequestMapping("/createClazz2")
	public String toCreateClazz2(HttpSession session) {
		System.out.println("111111111-------直接调测试方法");
//		return cs.getClazzName(3,new int[]{1,5,6,7,9,10,12,13,14,17,18,20,21});
		return cs.getClazzPC(15,-1);
	}
	@ResponseBody
	@RequestMapping("/allotClazzName")
	public String getClazzName(int id,int[] array) {
		System.out.println("分配班级编号名");
		return cs.getClazzName(id,array);
	}
	@ResponseBody
	@RequestMapping("/allotClazzPC")
	public String getClazzPC(int gid,int mid) {
		System.out.println("分配班级批次");
		return gid==0?null:cs.getClazzPC(gid,mid);
	}
	@ResponseBody
	@RequestMapping("/queryStudentForCreateClazz")
	public List<StudentVO> queryStudentForCreateClazz() {
		System.out.println("开班-查询学生");
		return ss.queryStudentForCreateClazz();
	}
	@ResponseBody
	@RequestMapping("/setupgradeSuccess")
	public int setupgradeSuccess(int[] array) {
		System.out.println("升学成功，修改升学表中状态为1");
		return ss.setupgradeSuccess(array);
	}
	@ResponseBody
	@RequestMapping("/isFirstGrade")
	public int isFirstGrade(int gid) {
		System.out.println("升学成功，修改升学表中状态为1");
		if(gid>0) {
			return gm.isFirstGrade(gid);
		}else {
			return -1;
		}
	}
}
