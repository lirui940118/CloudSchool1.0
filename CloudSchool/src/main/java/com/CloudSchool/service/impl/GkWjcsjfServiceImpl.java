package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.GkWjcsjfMapper;
import com.CloudSchool.service.GkWjcsjfService;
@Service
@Transactional
public class GkWjcsjfServiceImpl implements GkWjcsjfService{

	@Autowired
	GkWjcsjfMapper gkWjcsjfMapper;
	
	
	@Override
	public Integer queryAbilitWjBysIdAndgId(Integer sId, Integer gId,Integer tId) {
		return gkWjcsjfMapper.queryAbilitWjBysIdAndgId(sId, gId,tId);
	}


	@Override
	public Integer queryAbilitWjByStaffId(Integer staffId,Integer tId) {
		return gkWjcsjfMapper.queryAbilitWjByStaffId(staffId,tId);
	}

}
