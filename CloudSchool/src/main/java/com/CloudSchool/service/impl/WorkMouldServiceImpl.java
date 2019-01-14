package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.WorkmouldMapper;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Workmould;
import com.CloudSchool.domain.zjfvo.TeacherAdminStu;
import com.CloudSchool.service.WorkMouldService;
@Service
@Transactional
public class WorkMouldServiceImpl implements WorkMouldService{
	
	@Autowired
	WorkmouldMapper workmouldMapper;
	
	
	//根据教员ID查询作业模板
	@Override
	public PageBean queryByTidMould(Integer tid,Integer cur,Integer pagesize) {
		int count=workmouldMapper.queryByTidMouldCount(tid);
		PageBean page=new PageBean(count, pagesize, workmouldMapper.queryByTidMould(tid, (cur-1)*pagesize, pagesize), cur);
		return page;
	}

	
	//根据老师查询到管理的班级所有的学生
	@Override
	public List<TeacherAdminStu> queryByTidAdminStuAll(Integer tid) {
		// TODO Auto-generated method stub
		return workmouldMapper.queryByTidAdminStuAll(tid);
	}

}
