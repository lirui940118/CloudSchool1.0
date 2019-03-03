package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.LrKnowledagepointMapper;
import com.CloudSchool.domain.LrKnowledagepoint;
import com.CloudSchool.service.LrKnowledagepointService;
@Service
@Transactional
public class LrKnowledagepointServiceImpl implements LrKnowledagepointService{
	
	@Autowired
	LrKnowledagepointMapper lrKnowledagepointMapper;
	@Override
	public List<LrKnowledagepoint> queryBySid(Integer sid) {
		return lrKnowledagepointMapper.queryBySid(sid);
	}

}
