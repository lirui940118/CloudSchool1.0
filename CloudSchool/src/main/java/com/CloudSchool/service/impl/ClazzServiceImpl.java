package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.service.ClazzService;
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {
	@Autowired
	ClazzMapper cm;
	@Override
	public int CreateClass(ClazzInfo c) {
		int jg=cm.insert(c);
		return jg;
	}

}
