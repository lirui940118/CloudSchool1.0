package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.GkQuestionnairexx;

public interface GkQuestionnairexxMapper {
	//新增选项
	int insertXX(List<GkQuestionnairexx> listxx);
	
	
	
	
	
    int deleteByPrimaryKey(Integer wjxxId);

    int insert(GkQuestionnairexx record);

    int insertSelective(GkQuestionnairexx record);

    GkQuestionnairexx selectByPrimaryKey(Integer wjxxId);

    int updateByPrimaryKeySelective(GkQuestionnairexx record);

    int updateByPrimaryKey(GkQuestionnairexx record);
    
}