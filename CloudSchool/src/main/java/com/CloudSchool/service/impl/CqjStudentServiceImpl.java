package com.CloudSchool.service.impl;

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

}
