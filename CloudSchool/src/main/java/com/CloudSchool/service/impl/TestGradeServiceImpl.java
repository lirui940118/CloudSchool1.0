package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.TestgradeMapper;
import com.CloudSchool.domain.statistics.testVO;
import com.CloudSchool.service.TestGradeService;

@Service
@Transactional
public class TestGradeServiceImpl implements TestGradeService{

	@Autowired
	TestgradeMapper testgradeMapper;
	
	
	@Override
	public List<testVO> querySimStudentTestGradeBySid(Integer sId,Integer gId) {
		return testgradeMapper.querySimStudentTestGradeBySid(sId,gId);
	}

}
