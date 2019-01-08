package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnairetm;

public interface GkQuestionnairetmMapper {
    int deleteByPrimaryKey(Integer wjtmId);

    int insert(GkQuestionnairetm record);

    int insertSelective(GkQuestionnairetm record);

    GkQuestionnairetm selectByPrimaryKey(Integer wjtmId);

    int updateByPrimaryKeySelective(GkQuestionnairetm record);

    int updateByPrimaryKey(GkQuestionnairetm record);
}