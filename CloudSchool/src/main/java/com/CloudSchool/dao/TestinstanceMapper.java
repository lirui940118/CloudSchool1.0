package com.CloudSchool.dao;

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
}