package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnairesh;

public interface GkQuestionnaireshMapper {
    int deleteByPrimaryKey(Integer wjshId);

    int insert(GkQuestionnairesh record);

    int insertSelective(GkQuestionnairesh record);

    GkQuestionnairesh selectByPrimaryKey(Integer wjshId);

    int updateByPrimaryKeySelective(GkQuestionnairesh record);

    int updateByPrimaryKey(GkQuestionnairesh record);
}