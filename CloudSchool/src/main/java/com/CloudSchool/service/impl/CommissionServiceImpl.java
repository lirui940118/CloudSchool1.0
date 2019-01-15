package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.CommissionMapper;
import com.CloudSchool.domain.Commission;
import com.CloudSchool.service.CommissionService;
@Service
public class CommissionServiceImpl implements CommissionService{
	@Autowired
	CommissionMapper com;
	
	public List<Commission> query() {
		return com.query();
	}

}
