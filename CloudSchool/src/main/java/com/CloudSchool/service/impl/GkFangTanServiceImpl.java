package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkInterviewMapper;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.service.GkFangTanService;


@Service
public class GkFangTanServiceImpl implements GkFangTanService{
	@Autowired
	GkInterviewMapper gkInterviewMapper;
	//查询所有访谈
	public GkPageBean<GkInterview> queryAllFangTan(Integer currentPage, Integer pageSize) {
		int index = (currentPage-1)*pageSize; //下标
		List<GkInterview> list = gkInterviewMapper.queryAllFangTan(index, pageSize);
		int totalSize = (int)gkInterviewMapper.queryAllFangTanCount();
		GkPageBean<GkInterview> page = new GkPageBean<GkInterview>(currentPage, pageSize, totalSize, list);
		return page;
	}
}
