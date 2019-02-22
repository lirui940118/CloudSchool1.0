package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.GkQuestionnaire;

public interface GkQuestionnaireMapper {
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