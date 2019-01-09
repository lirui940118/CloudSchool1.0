package com.CloudSchool.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.domain.Clazzstudent;
import com.CloudSchool.service.ClazzService;

@Controller
public class CreateClazzController {
	@Autowired
	ClazzService cs;
	@RequestMapping(value="createClazz",method=RequestMethod.GET)
	public String toCreateClazz() {
		System.out.println("跳转页面-开班");
		return "tzx/createClazz";
	}
	@ResponseBody
	@RequestMapping(value="craeteClazz",method=RequestMethod.POST)
	public int createClazz(ClazzInfo c) {
//		c.setId(11);
		System.out.println("开班-新增班级");

		//预添加数据------------
		c.setCname("AT1717");
		c.setGid(1);
		c.setMid(1);
		c.setCount(30);
		c.setStatus(0);
		c.setPc("20190001");
		c.setSlist(new ArrayList<Clazzstudent>());
		c.setTlist(new ArrayList<Clazzcourseteacher>());
		Clazzstudent cls=new Clazzstudent();
		Clazzstudent cls1=new Clazzstudent();
		cls.setSid(55);
		cls1.setSid(66);
		c.getSlist().add(cls);
		c.getSlist().add(cls1);
		Clazzcourseteacher cct=new Clazzcourseteacher();
		Clazzcourseteacher cct1=new Clazzcourseteacher();
		cct.setCourseid(11);
		cct.setTid(22);
		cct.setIsmaster(1);
		cct.setIsteacher(0);
		cct1.setCourseid(12);
		cct1.setTid(23);
		cct1.setIsmaster(0);
		cct1.setIsteacher(1);
		c.getTlist().add(cct);
		c.getTlist().add(cct1);
		//预添加数据------------
		return cs.CreateClass(c);
	}
	@ResponseBody
	@RequestMapping("createClazz1")
	public void toCreateClazz1() {
		System.out.println("111111111-------直接调开班方法");
		createClazz(new ClazzInfo());
	}
}
