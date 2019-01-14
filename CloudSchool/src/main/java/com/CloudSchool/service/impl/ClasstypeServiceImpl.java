package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ClasstypeMapper;
import com.CloudSchool.domain.Classtype;
import com.CloudSchool.service.ClasstypeService;
@Service
public class ClasstypeServiceImpl implements ClasstypeService{
	@Autowired
	ClasstypeMapper	clt;

	@Override
	public List<Classtype> query() {
		return clt.query();
	}
	
}
