package com.CloudSchool.dao;

import com.CloudSchool.domain.GkQuestionnairetmType;

public interface GkQuestionnairetmTypeMapper {
    int deleteByPrimaryKey(Integer wjtmTypeId);

    int insert(GkQuestionnairetmType record);

    int insertSelective(GkQuestionnairetmType record);

    GkQuestionnairetmType selectByPrimaryKey(Integer wjtmTypeId);

    int updateByPrimaryKeySelective(GkQuestionnairetmType record);

    int updateByPrimaryKey(GkQuestionnairetmType record);
}