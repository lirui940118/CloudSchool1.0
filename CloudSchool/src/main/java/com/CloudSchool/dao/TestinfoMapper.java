package com.CloudSchool.dao;

import java.util.Map;

import com.CloudSchool.domain.Testinfo;

public interface TestinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testinfo record);

    int insertSelective(Testinfo record);

    Testinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testinfo record);

    int updateByPrimaryKey(Testinfo record);
    
    int insertList(Map<String, Object> map);
}