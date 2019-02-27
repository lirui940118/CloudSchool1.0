package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.GkQuestionnairexxType;

public interface GkQuestionnairexxTypeMapper {
	
	//查询所有选项类型
	List<GkQuestionnairexxType> queryAllXXLeiXing();
	
    int deleteByPrimaryKey(Integer wjxxTypeId);

    int insert(GkQuestionnairexxType record);

    int insertSelective(GkQuestionnairexxType record);

    GkQuestionnairexxType selectByPrimaryKey(Integer wjxxTypeId);

    int updateByPrimaryKeySelective(GkQuestionnairexxType record);

    int updateByPrimaryKey(GkQuestionnairexxType record);
}