package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnairexxType;

public interface GkQuestionnairexxTypeMapper {
    int deleteByPrimaryKey(Integer wjxxTypeId);

    int insert(GkQuestionnairexxType record);

    int insertSelective(GkQuestionnairexxType record);

    GkQuestionnairexxType selectByPrimaryKey(Integer wjxxTypeId);

    int updateByPrimaryKeySelective(GkQuestionnairexxType record);

    int updateByPrimaryKey(GkQuestionnairexxType record);
}