package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.domain.GkQuestionnaire;
import com.CloudSchool.domain.GkQuestionnaireType;
import com.CloudSchool.domain.GkQuestionnairetm;
import com.CloudSchool.domain.GkQuestionnairetmType;
import com.CloudSchool.domain.GkQuestionnairexx;
import com.CloudSchool.domain.GkQuestionnairexxType;
import com.CloudSchool.domain.GkWjcs;

public interface GkWenJuanService {
	//完善问卷选择
	int updateWjcs(GkWjcs wj);
	//查询需要自己填写的问卷（选择）
	GkPageBean<GkQuestionnaire> queryinsertByUserid2(GkQuestionnaire wj);
	
	//新增选项
	int insertXX(List<GkQuestionnairexx> list);
	//新增题目 
	int insertTiMu(GkQuestionnairetm tm);
	//查询所有题目类型
	List<GkQuestionnairetmType> queryAllTiMuType();
	//查询需要自己填写的问卷（计分）
	GkPageBean<GkQuestionnaire> queryinsertByUserid(GkQuestionnaire wj);
	
	//新增问卷发布记录表gk_questionnaire
	int insertWenJuanFB(GkQuestionnaire wj);
	//通过问卷id查询说明
	GkQuestionnaire queryShuoMingBywjId(Integer wjId);
	//通过问卷类型，选项类型查询问卷
	List<GkQuestionnaire> queryWenJuanBywjTypeIdAndwjxxTypeId(Integer wjTypeId,Integer wjxxTypeId);
	
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
