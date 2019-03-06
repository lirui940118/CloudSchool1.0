package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ClassroomMapper;
import com.CloudSchool.domain.Classroom;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.service.ClassroomService;
@Service
public class ClassroomServiceImpl implements ClassroomService{
	@Autowired
	ClassroomMapper clr;
	
	public List<Classroom> query(){
		return clr.query();
	}

	@Override
	public int insert(Classroom cls) {
		return clr.insertSelective(cls);
	}

	@Override
	public int delete(Integer id) {
		return clr.deleteByPrimaryKey(id);
	}

	@Override
	public Classroom selectByid(Integer id) {
		return clr.selectByPrimaryKey(id);
	}

	@Override
	public int update(Classroom cls) {
		return clr.updateByPrimaryKeySelective(cls);
	}

	@Override
	public int insertSelective(Classroom record) {
		return clr.insertSelective(record);
	}

	@Override
	public Classroom queryByroomid(Integer id) {
		// TODO Auto-generated method stub
		return clr.queryByroomid(id);
	}

	@Override
	public PageBean pageRoom(Integer cur, Integer pageSize) {
		// TODO Auto-generated method stub
		int count=clr.queryCunt();
		int cur1=(cur-1)*pageSize;
		List<Classroom> list=clr.pageRoom(cur1, pageSize);
		PageBean page=new PageBean(count, pageSize,list , cur);
		return page;
	}

}
