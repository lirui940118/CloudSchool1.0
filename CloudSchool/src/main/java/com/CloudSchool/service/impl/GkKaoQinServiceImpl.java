package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkKaoqinMapper;
import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.service.GkKaoQinService;

@Service
public class GkKaoQinServiceImpl implements GkKaoQinService{

	@Autowired
	GkKaoqinMapper gkKaoqinMapper;
	
	@Override
	public GkPageBean<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq) {
		// TODO Auto-generated method stub
		System.out.println(kq.getStartStr());
		System.out.println(kq.getEndStr());
		GkKaoqin kq2 = new GkKaoqin();
		kq2.setCurrentPage((kq.getCurrentPage()-1)*kq.getPageSize());//下标
		kq2.setPositionname(kq.getPositionname());
		kq2.setPageSize(kq.getPageSize());
		kq2.setStaffname(kq.getStaffname());
		kq2.setStartStr(kq.getStartStr());
		kq2.setEndStr(kq.getEndStr());
		List<GkKaoqin> list = gkKaoqinMapper.queryAllKaoQinYuanGong(kq2);
		int totalSize = (int)gkKaoqinMapper.queryAllKaoQinYuanGongCount(kq2);
		GkPageBean<GkKaoqin> page = new GkPageBean<GkKaoqin>(kq.getCurrentPage(), kq.getPageSize(), totalSize, list);
		return page;
	}

	@Override
	public Double querykaoqinRateBygIdAndsId(Integer sId, Integer gId) {
		return gkKaoqinMapper.querykaoqinRateBygIdAndsId(sId, gId);
	}

	@Override
	public Double querykaoqinRateByStaffId(Integer staffId) {
		return gkKaoqinMapper.querykaoqinRateByStaffId(staffId);
	}

	
}
