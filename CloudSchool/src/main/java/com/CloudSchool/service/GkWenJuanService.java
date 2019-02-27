package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.domain.GkQuestionnaire;
import com.CloudSchool.domain.GkQuestionnaireType;
import com.CloudSchool.domain.GkQuestionnairetm;
import com.CloudSchool.domain.GkQuestionnairexxType;

public interface GkWenJuanService {
	//新增问卷题目关联表
	int insertWJTMFK(Integer[] shuzu,Integer wjId);
	//创建问卷
	int insertWenJuanCJ(GkQuestionnaire wj);
	//通过问卷类型，选项类型查询题目
	List<GkQuestionnairetm> queryAllTiMuByXXandwj(Integer xx,Integer wj);
	//查询所有选项类型
	List<GkQuestionnairexxType> queryAllXXLeiXing();
	//查询所有问卷类型
	List<GkQuestionnaireType> queryAllWenJuanLeiXing();
	//查询问卷发布记录
	GkPageBean<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj);
}
