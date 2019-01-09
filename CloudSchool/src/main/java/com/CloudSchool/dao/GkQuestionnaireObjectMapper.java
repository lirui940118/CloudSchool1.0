package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnaireObject;

public interface GkQuestionnaireObjectMapper {
    int deleteByPrimaryKey(Integer wjdxId);

    int insert(GkQuestionnaireObject record);

    int insertSelective(GkQuestionnaireObject record);

    GkQuestionnaireObject selectByPrimaryKey(Integer wjdxId);

    int updateByPrimaryKeySelective(GkQuestionnaireObject record);

    int updateByPrimaryKey(GkQuestionnaireObject record);
}