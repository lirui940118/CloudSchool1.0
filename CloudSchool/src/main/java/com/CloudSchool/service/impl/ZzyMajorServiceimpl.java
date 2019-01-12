package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzyMajorMapper;
import com.CloudSchool.domain.ZzyMajor;
import com.CloudSchool.service.ZzyMajorService;

@Service
@Transactional
public class ZzyMajorServiceimpl implements ZzyMajorService{
	@Autowired
	ZzyMajorMapper ma;

	@Override
	public int insertList(List<ZzyMajor> list) {
		// TODO Auto-generated method stub
		return ma.insertList(list);
	}

	@Override
	public List<ZzyMajor> queryAll() {
		// TODO Auto-generated method stub
		return ma.queryAll();
	}
	
}
