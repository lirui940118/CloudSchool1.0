package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.WorkgradeMapper;
import com.CloudSchool.domain.statistics.WorkGradeVo;
import com.CloudSchool.service.WorkgradeService;
@Service
@Transactional
public class WorkgradeServiceImpl implements WorkgradeService{

	@Autowired
	WorkgradeMapper workgradeMapper;
	
	
	@Override
	public List<WorkGradeVo> queryStudentWorkInfoBysIdAndgId(Integer sId, Integer gId) {
		return workgradeMapper.queryStudentWorkInfoBysIdAndgId(sId, gId);
	}


	@Override
	public Double queryStudentWorkTimelyFinishRate(Integer sId, Integer gId) {
		return workgradeMapper.queryStudentWorkTimelyFinishRate(sId, gId);
	}

}
