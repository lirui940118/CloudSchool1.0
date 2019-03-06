package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkQuestionnaireMapper;
import com.CloudSchool.dao.GkQuestionnaireTypeMapper;
import com.CloudSchool.dao.GkQuestionnairetmMapper;
import com.CloudSchool.dao.GkQuestionnairetmTypeMapper;
import com.CloudSchool.dao.GkQuestionnairexxMapper;
import com.CloudSchool.dao.GkQuestionnairexxTypeMapper;
import com.CloudSchool.dao.GkWjtmFkMapper;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.domain.GkQuestionnaire;
import com.CloudSchool.domain.GkQuestionnaireType;
import com.CloudSchool.domain.GkQuestionnairetm;
import com.CloudSchool.domain.GkQuestionnairetmType;
import com.CloudSchool.domain.GkQuestionnairexx;
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
	//问卷题目类型
	@Autowired
	GkQuestionnairetmTypeMapper gkquestionnairetmTypeMapper;
	//问卷选项
	@Autowired
	GkQuestionnairexxMapper gkQuestionnairexxMapper;
	
	@Override
	public GkPageBean<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj) {
		// TODO Auto-generated method stub
//		if(wj.getEndStr().equals("")) {
//			wj.setEndStr(null);
//		}
//		if(wj.getStartStr().equals("")) {
//			wj.setStartStr(null);
//		}
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

	@Override
	public List<GkQuestionnaire> queryWenJuanBywjTypeIdAndwjxxTypeId(Integer wjTypeId, Integer wjxxTypeId) {
		// TODO Auto-generated method stub
		return gkQuestionnaireMapper.queryWenJuanBywjTypeIdAndwjxxTypeId(wjTypeId, wjxxTypeId);
	}

	@Override
	public GkQuestionnaire queryShuoMingBywjId(Integer wjId) {
		// TODO Auto-generated method stub
		return gkQuestionnaireMapper.queryShuoMingBywjId(wjId);
	}

	@Override
	public int insertWenJuanFB(GkQuestionnaire wj) {
		// TODO Auto-generated method stub
		return gkQuestionnaireMapper.insertWenJuanFB(wj);
	}

	@Override
	public GkPageBean<GkQuestionnaire> queryinsertByUserid(GkQuestionnaire wj) {
		// TODO Auto-generated method stub
		GkQuestionnaire wj2 = new GkQuestionnaire();
		wj2.setCurrentPage((wj.getCurrentPage()-1)*wj.getPageSize());//下标
		wj2.setPageSize(wj.getPageSize());
		wj2.setzId(wj.getzId());
		List<GkQuestionnaire> list = gkQuestionnaireMapper.queryinsertByUserid(wj2);
		int totalSize = (int)gkQuestionnaireMapper.queryinsertByUseridCount(wj2);
		GkPageBean<GkQuestionnaire> page = new GkPageBean<GkQuestionnaire>(wj.getCurrentPage(), wj.getPageSize(), totalSize, list);
		
		return page;
	}

	@Override
	public List<GkQuestionnairetmType> queryAllTiMuType() {
		// TODO Auto-generated method stub
		return gkquestionnairetmTypeMapper.queryAllTiMuType();
	}

	@Override
	public int insertTiMu(GkQuestionnairetm tm) {
		// TODO Auto-generated method stub
		return gkQuestionnairetmMapper.insertTiMu(tm);
	}

	@Override
	public int insertXX(List<GkQuestionnairexx> listxx) {
		// TODO Auto-generated method stub
		System.out.println(listxx);
		System.out.println(123);
		for (GkQuestionnairexx l : listxx) {
			System.out.println(l.getWjxxName());
		}
		return gkQuestionnairexxMapper.insertXX(listxx);
	}

}
