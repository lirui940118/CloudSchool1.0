package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.TesttypeMapper;
import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.domain.PageBean;
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
	
	@Autowired
	ClazzMapper clazzMapper;
	
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

	@Override
	public Object queryClass(Integer id, Integer sid, Integer cur, Integer pagesize, Integer cid) {
		if(id==1) {
			int datas=clazzMapper.queryAllClazzCount(cid);
			//有权限
			PageBean page=new PageBean(datas, pagesize,clazzMapper.queryAllClazz((cur-1)*pagesize,pagesize,cid), cur);
			return page;
		}
		int datas=clazzMapper.queryByTidAdminClazzCount(sid,cid);
		//有权限
		PageBean page=new PageBean(datas, pagesize,clazzMapper.queryByTidAdminClazz(sid, (cur-1)*pagesize, pagesize,cid),cur);
		return page;
	}

}
