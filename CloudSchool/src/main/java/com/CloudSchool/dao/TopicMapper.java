package com.CloudSchool.dao;

import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicWithBLOBs record);

    int insertSelective(TopicWithBLOBs record);

    TopicWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TopicWithBLOBs record);

    int updateByPrimaryKey(Topic record);
}