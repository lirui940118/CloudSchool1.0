package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ParticipateteststuMapper;
import com.CloudSchool.domain.PageBean;
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
	
	@Override
	public PageBean queryTestInfoBySidAndTidCorrect(Integer id, Integer sid, Integer cur, Integer pagesize) {
		Integer count=participateteststuMapper.queryTestInfoBySidAndTidCorrectCount(id, sid);
		PageBean page=new PageBean(count, pagesize, participateteststuMapper.queryTestInfoBySidAndTidCorrect(id, sid, (cur-1)*pagesize, pagesize), cur);
		return page;
	}

	@Override
	public boolean queryIsTestBySidAndTid(Integer sId, Integer tId) {
		String temp =participateteststuMapper.queryIsTestBySidAndTid(sId, tId);
		if(temp.equals("0"))//缺考
			return false;
		else
			return true;//参加考试
		
	}
	
}
