package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkQuestionnaireMapper;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.domain.GkQuestionnaire;
import com.CloudSchool.service.GkWenJuanService;

@Service
public class GkWenJuanServiceImpl implements GkWenJuanService{

	@Autowired
	GkQuestionnaireMapper gkQuestionnaireMapper;
	
	@Override
	public GkPageBean<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj) {
		// TODO Auto-generated method stub
		GkQuestionnaire wj2 = new GkQuestionnaire();
		wj2.setCurrentPage((wj.getCurrentPage()-1)*wj.getPageSize());//下标
		wj2.setWjObject(wj.getWjObject());
		wj2.setPageSize(wj.getPageSize());
		wj2.setStaffname(wj.getStaffname());
		wj2.setStartStr(wj.getStartStr());
		wj2.setEndStr(wj.getEndStr());
		List<GkQuestionnaire> list = gkQuestionnaireMapper.queryAllWenJuanFaBuJiLu(wj2);
		int totalSize = (int)gkQuestionnaireMapper.queryAllWenJuanFaBuJiLuCount(wj2);
		GkPageBean<GkQuestionnaire> page = new GkPageBean<GkQuestionnaire>(wj.getCurrentPage(), wj.getPageSize(), totalSize, list);
		return page;
	}

}
