package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnaire;

public interface GkQuestionnaireMapper {
    int deleteByPrimaryKey(Integer wjId);

    int insert(GkQuestionnaire record);

    int insertSelective(GkQuestionnaire record);

    GkQuestionnaire selectByPrimaryKey(Integer wjId);

    int updateByPrimaryKeySelective(GkQuestionnaire record);

    int updateByPrimaryKey(GkQuestionnaire record);
}