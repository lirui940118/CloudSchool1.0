package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.GkQuestionnairetmType;

public interface GkQuestionnairetmTypeMapper {
	//查询所有题目类型
	List<GkQuestionnairetmType> queryAllTiMuType();
	
	
	
	
    int deleteByPrimaryKey(Integer wjtmTypeId);

    int insert(GkQuestionnairetmType record);

    int insertSelective(GkQuestionnairetmType record);

    GkQuestionnairetmType selectByPrimaryKey(Integer wjtmTypeId);

    int updateByPrimaryKeySelective(GkQuestionnairetmType record);

    int updateByPrimaryKey(GkQuestionnairetmType record);
}