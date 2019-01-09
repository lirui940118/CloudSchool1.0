package com.CloudSchool.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.service.ClazzService;
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

	@Override
	public int CreateClass(ClazzInfo c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
