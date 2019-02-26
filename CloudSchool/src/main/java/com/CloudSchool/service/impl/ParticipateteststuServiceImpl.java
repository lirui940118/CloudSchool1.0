package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ParticipateteststuMapper;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.zjfvo.StuTestInfo;
import com.CloudSchool.domain.zjfvo.TestInfo;
import com.CloudSchool.service.ParticipateteststuService;

@Service
@Transactional
public class ParticipateteststuServiceImpl implements ParticipateteststuService{
	@Autowired
	ParticipateteststuMapper participateteststuMapper;

	@Override
	public List<StuTestInfo> queryStuTestAllBySid(Integer sid) {
		return participateteststuMapper.queryStuTestAllBySid(sid);
	}

	@Override
	public TestInfo queryTestInfoBySidAndTid(Integer id, Integer sid) {
		return participateteststuMapper.queryTestInfoBySidAndTid(id, sid);
	}
	
}
