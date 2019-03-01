package com.CloudSchool.dao;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Testinstance;

public interface TestinstanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testinstance record);

    int insertSelective(Testinstance record);

    Testinstance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testinstance record);

    int updateByPrimaryKey(Testinstance record);
    
    //生成作业实例
    int insertTestInstance(Testinstance obj);
    
 int queryByTypeCount(@Param("tid")Integer tid,@Param("id")Integer id);
    
    int queryTestTopicCount(Integer tid);
}