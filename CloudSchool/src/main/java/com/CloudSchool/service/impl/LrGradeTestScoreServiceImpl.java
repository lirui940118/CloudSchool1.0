package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.LrGradeTestScoreMapper;
import com.CloudSchool.domain.statistics.TestComprehensiveScoreVO;
import com.CloudSchool.service.LrGradeTestScoreService;

@Service
public class LrGradeTestScoreServiceImpl implements LrGradeTestScoreService{

	@Autowired
	LrGradeTestScoreMapper lrGradeTestScoreMapper;
	
	@Override
	public List<TestComprehensiveScoreVO> getClazzTestsAvgScoreByPc(String pc) {
		return lrGradeTestScoreMapper.getClazzTestsAvgScoreByPc(pc);
	}
	 
}
