package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.CqjStudentMapper;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.service.CqjStudentService;
@Service
public class CqjStudentServiceImpl implements CqjStudentService{

	@Autowired
	CqjStudentMapper cqjStudentMapper;
	@Override
	public CqjStudent queryStudentInfoBySid(Integer sId) {
		return cqjStudentMapper.queryStudentInfoBySid(sId);
	}
	@Override
	public List<CqjStudent> queryTongXueByUserid(Integer uid) {
		// TODO Auto-generated method stub
		return cqjStudentMapper.queryTongXueByUserid(uid);
	}

}
