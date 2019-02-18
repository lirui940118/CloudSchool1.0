package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.TesttypeMapper;
import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.domain.Testtype;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.service.TestInstanceService;
@Service
@Transactional
public class TestInstanceServiceImpl implements TestInstanceService{
	
	@Autowired
	TesttypeMapper testtypeMapper;
	@Autowired
	ZzyGradeMapper zzyGradeMapper;
	
	//查询所有班级  有权限
	@Override
	public List<ZzyGrade> queryGrade(String id) {
		//试卷类型
		List<Testtype> list=testtypeMapper.queryBylimits("%"+id+",%");
		for (Testtype obj : list) {
			if(obj.getId()>1) {
				return zzyGradeMapper.queryAll();
			}
		}
		return null;
	}

}
