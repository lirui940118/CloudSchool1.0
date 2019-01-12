package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.Topictype;

public interface TopictypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topictype record);

    int insertSelective(Topictype record);

    Topictype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topictype record);

    int updateByPrimaryKey(Topictype record);
    List<Topictype> queryTopicTypeAll();
}