package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnairetmSh;

public interface GkQuestionnairetmShMapper {
    int deleteByPrimaryKey(Integer wjtmId);

    int insert(GkQuestionnairetmSh record);

    int insertSelective(GkQuestionnairetmSh record);

    GkQuestionnairetmSh selectByPrimaryKey(Integer wjtmId);

    int updateByPrimaryKeySelective(GkQuestionnairetmSh record);

    int updateByPrimaryKey(GkQuestionnairetmSh record);
}