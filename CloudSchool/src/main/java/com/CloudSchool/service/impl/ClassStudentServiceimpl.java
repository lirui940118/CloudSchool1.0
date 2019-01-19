package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ClazzstudentMapper;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.Clazzstudent;
import com.CloudSchool.service.ClassStudentService;

@Service
public class ClassStudentServiceimpl implements ClassStudentService{
	@Autowired
	ClazzstudentMapper clas;

	@Override
	public List<Clazzstudent> queryByMo(Integer cid) {
		// TODO Auto-generated method stub
		return clas.queryByMo(cid);
	}

	@Override
	public List<Clazzstudent> queryZc(Integer cid) {
		// TODO Auto-generated method stub
		return clas.queryZc(cid);
	}

	@Override
	public List<Clazzstudent> queryBystatus() {
		// TODO Auto-generated method stub
		return clas.queryBystatus();
	}



	@Override
	public int updateByid(Clazzstudent record) {
		// TODO Auto-generated method stub
		return clas.updateByid(record);
	}

	@Override
	public int insertOne(Clazzstudent record) {
		// TODO Auto-generated method stub
		return clas.insertOne(record);
	}
}
