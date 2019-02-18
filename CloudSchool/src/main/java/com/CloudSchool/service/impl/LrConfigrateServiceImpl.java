package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.LrConfigrateMapper;
import com.CloudSchool.domain.LrConfigrate;
import com.CloudSchool.service.LrConfigrateService;

@Service
public class LrConfigrateServiceImpl implements LrConfigrateService{

	@Autowired
	LrConfigrateMapper lrConfigrateMapper;
	
	@Override
	public LrConfigrate queryAllConfig() {
		return lrConfigrateMapper.queryAllConfig();
	}

	@Override
	public Integer updateAllConfig(LrConfigrate record) {
		return lrConfigrateMapper.updateAllConfig(record);
	}

}
