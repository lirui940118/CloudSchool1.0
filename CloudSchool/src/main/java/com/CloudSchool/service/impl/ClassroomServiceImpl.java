package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ClassroomMapper;
import com.CloudSchool.domain.Classroom;
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
		return clr.insert(cls);
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

}
