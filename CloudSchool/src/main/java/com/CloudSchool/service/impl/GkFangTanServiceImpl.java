package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkInterviewMapper;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.service.GkFangTanService;


@Service
public class GkFangTanServiceImpl implements GkFangTanService{
	@Autowired
	GkInterviewMapper gkInterviewMapper;
	//查询所有访谈
	public GkPageBean<GkInterview> queryAllFangTan(GkFangTan ft) {
		//int index = (ft.getCurrentPage()-1)*ft.getPageSize(); 
		GkFangTan ft2 = new GkFangTan();
		ft2.setCurrentPage((ft.getCurrentPage()-1)*ft.getPageSize());//下标
		ft2.setEndtime(ft.getEndtime());
		ft2.setObjectname(ft.getObjectname());
		ft2.setPageSize(ft.getPageSize());
		ft2.setPeoplename(ft.getPeoplename());
		ft2.setStarttime(ft.getStarttime());
		List<GkInterview> list = gkInterviewMapper.queryAllFangTan(ft2);
		int totalSize = (int)gkInterviewMapper.queryAllFangTanCount(ft2);
		GkPageBean<GkInterview> page = new GkPageBean<GkInterview>(ft.getCurrentPage(), ft.getPageSize(), totalSize, list);
		return page;
	}
}
