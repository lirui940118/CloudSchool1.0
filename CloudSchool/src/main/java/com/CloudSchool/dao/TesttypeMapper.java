package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.Testtype;
import com.CloudSchool.domain.Topictype;

public interface TesttypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testtype record);

    int insertSelective(Testtype record);

    Testtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testtype record);

    int updateByPrimaryKey(Testtype record);
    
   
}