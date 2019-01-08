package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnaireType;

public interface GkQuestionnaireTypeMapper {
    int deleteByPrimaryKey(Integer wjTypeId);

    int insert(GkQuestionnaireType record);

    int insertSelective(GkQuestionnaireType record);

    GkQuestionnaireType selectByPrimaryKey(Integer wjTypeId);

    int updateByPrimaryKeySelective(GkQuestionnaireType record);

    int updateByPrimaryKey(GkQuestionnaireType record);
}