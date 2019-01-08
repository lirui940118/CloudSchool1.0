package com.CloudSchool.dao;

import com.CloudSchool.domain.Topicoption;

public interface TopicoptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topicoption record);

    int insertSelective(Topicoption record);

    Topicoption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topicoption record);

    int updateByPrimaryKeyWithBLOBs(Topicoption record);

    int updateByPrimaryKey(Topicoption record);
}