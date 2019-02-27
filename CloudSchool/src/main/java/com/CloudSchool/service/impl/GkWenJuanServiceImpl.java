package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkQuestionnaireMapper;
import com.CloudSchool.dao.GkQuestionnaireTypeMapper;
import com.CloudSchool.dao.GkQuestionnairetmMapper;
import com.CloudSchool.dao.GkQuestionnairexxTypeMapper;
import com.CloudSchool.dao.GkWjtmFkMapper;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.domain.GkQuestionnaire;
import com.CloudSchool.domain.GkQuestionnaireType;
import com.CloudSchool.domain.GkQuestionnairetm;
import com.CloudSchool.domain.GkQuestionnairexxType;
import com.CloudSchool.service.GkWenJuanService;

@Service
public class GkWenJuanServiceImpl implements GkWenJuanService{

	//问卷
	@Autowired
	GkQuestionnaireMapper gkQuestionnaireMapper;
	//问卷类型
	@Autowired
	GkQuestionnaireTypeMapper gkQuestionnaireTypeMapper;
	//问卷选项类型
	@Autowired
	GkQuestionnairexxTypeMapper gkQuestionnairexxTypeMapper;
	//问卷题目
	@Autowired
	GkQuestionnairetmMapper gkQuestionnairetmMapper;
	//问卷题目关联表
	@Autowired
	GkWjtmFkMapper gkWjtmFkMapper;
	
	@Override
	public GkPageBean<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj) {
		// TODO Auto-generated method stub
		if(wj.getEndStr().equals("")) {
			wj.setEndStr(null);
		}
		if(wj.getStartStr().equals("")) {
			wj.setStartStr(null);
		}
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

	@Override
	public List<GkQuestionnaireType> queryAllWenJuanLeiXing() {
		// TODO Auto-generated method stub
		return gkQuestionnaireTypeMapper.queryAllWenJuanLeiXing();
	}

	@Override
	public List<GkQuestionnairexxType> queryAllXXLeiXing() {
		// TODO Auto-generated method stub
		return gkQuestionnairexxTypeMapper.queryAllXXLeiXing();
	}

	@Override
	public List<GkQuestionnairetm> queryAllTiMuByXXandwj(Integer xx, Integer wj) {
		// TODO Auto-generated method stub
		return gkQuestionnairetmMapper.queryAllTiMuByXXandwj(xx, wj);
	}

	@Override
	public int insertWenJuanCJ(GkQuestionnaire wj) {
		// TODO Auto-generated method stub
		return gkQuestionnaireMapper.insertWenJuanCJ(wj);
	}

	@Override
	public int insertWJTMFK(Integer[] shuzu, Integer wjId) {
		// TODO Auto-generated method stub
		return gkWjtmFkMapper.insertWJTMFK(shuzu, wjId);
	}

}
