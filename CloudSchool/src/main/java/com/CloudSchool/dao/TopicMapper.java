package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicWithBLOBs record);
    /*添加题目*/
    int insertSelective(TopicWithBLOBs record);

    TopicWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TopicWithBLOBs record);

    int updateByPrimaryKey(Topic record);
    int queryCount(Topic obj);
    List<Topic> conditionsQueryTopci(@Param("obj")Topic obj,@Param("cur")Integer cur,@Param("pagesize")Integer pagesize);
}