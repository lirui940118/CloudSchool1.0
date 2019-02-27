package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.GkQuestionnaireType;

public interface GkQuestionnaireTypeMapper {
	//查询所有问卷类型
	List<GkQuestionnaireType> queryAllWenJuanLeiXing();
	
	
    int deleteByPrimaryKey(Integer wjTypeId);

    int insert(GkQuestionnaireType record);

    int insertSelective(GkQuestionnaireType record);

    GkQuestionnaireType selectByPrimaryKey(Integer wjTypeId);

    int updateByPrimaryKeySelective(GkQuestionnaireType record);

    int updateByPrimaryKey(GkQuestionnaireType record);
}