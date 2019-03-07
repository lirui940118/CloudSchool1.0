package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkQuestionnaire;

public interface GkQuestionnaireMapper {
	//查询需要自己填写的问卷（选择）
	int queryinsertByUseridCount2(GkQuestionnaire wj);
	//查询需要自己填写的问卷（选择）
	List<GkQuestionnaire> queryinsertByUserid2(GkQuestionnaire wj);
	
	
	//查询需要自己填写的问卷（计分）
	int queryinsertByUseridCount(GkQuestionnaire wj);
	//查询需要自己填写的问卷（计分）
	List<GkQuestionnaire> queryinsertByUserid(GkQuestionnaire wj);
	
	//新增问卷发布记录表gk_questionnaire
	int insertWenJuanFB(GkQuestionnaire wj);
	//通过问卷id查询说明
	GkQuestionnaire queryShuoMingBywjId(Integer wjId);
	//通过问卷类型，选项类型查询问卷
	List<GkQuestionnaire> queryWenJuanBywjTypeIdAndwjxxTypeId(@Param("wjTypeId")Integer wjTypeId,@Param("wjxxTypeId")Integer wjxxTypeId);
	//创建问卷
	int insertWenJuanCJ(GkQuestionnaire wj);
	//查询问卷发布记录
	List<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj);
	//查询问卷发布记录行数
	int queryAllWenJuanFaBuJiLuCount(GkQuestionnaire wj);
	
	
    int deleteByPrimaryKey(Integer wjId);

    int insert(GkQuestionnaire record);

    int insertSelective(GkQuestionnaire record);

    GkQuestionnaire selectByPrimaryKey(Integer wjId);

    int updateByPrimaryKeySelective(GkQuestionnaire record);

    int updateByPrimaryKey(GkQuestionnaire record);
}