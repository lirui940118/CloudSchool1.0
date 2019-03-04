package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ParticipatetestclassMapper;
import com.CloudSchool.dao.ParticipateteststuMapper;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Participatetestclass;
import com.CloudSchool.domain.zjfvo.TeachTestCorrect;
import com.CloudSchool.domain.zjfvo.TestInfoAll;
import com.CloudSchool.service.ParticipatetestcCassService;
@Service
@Transactional
public class ParticipatetestcCassServiceImpl implements ParticipatetestcCassService{

	@Autowired
	ParticipatetestclassMapper participatetestclassMapper;
	@Autowired
	ParticipateteststuMapper participateteststuMapper;
	@Override
	public List<TeachTestCorrect> queryMyCorrectTest(Integer uid) {
		return participatetestclassMapper.queryMyCorrectTest(uid);
	}
	@Override
	public List<TestInfoAll> queryByTidTestInfo(Integer tid, Integer cid) {
		return participatetestclassMapper.queryByTidTestInfo(tid, cid);
	}
	
	public int updateTestClassStatus(Participatetestclass obj) {
		Integer i=participateteststuMapper.queryNotCorrectCountByUser1(obj.getTid(), obj.getId(),2);
		if(i<=0) {
			obj.setUser3("6");
			return participatetestclassMapper.updateTestStatus(obj);
		}
		return 0;
	}
	

}
