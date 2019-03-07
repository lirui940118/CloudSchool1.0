package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkWjcsMapper;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkWjcs;
import com.CloudSchool.service.GkWjcsService;
import com.alibaba.fastjson.JSON;

@Service
public class GkWjcsServiceImpl implements GkWjcsService{

	@Autowired
	GkWjcsMapper gkWjcsMapper;
	
	@Override
	public int insertWjcs(List<CqjUser> quanbulist,Integer wjId) {
		// TODO Auto-generated method stub
		return gkWjcsMapper.insertWjcs(quanbulist,wjId);
	}

}
