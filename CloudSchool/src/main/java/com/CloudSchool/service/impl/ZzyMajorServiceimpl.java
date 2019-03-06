package com.CloudSchool.service.impl;

import java.util.List;
import java.util.Map;

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
	public int insertList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ma.insertList(map);
	}











	@Override
	public List<ZzyMajor> queryAll() {
		// TODO Auto-generated method stub
		return ma.queryAll();
	}











	@Override
	public List<ZzyMajor> queryAll2(Integer vid) {
		// TODO Auto-generated method stub
		return ma.queryAll2(vid);
	}
	
}
