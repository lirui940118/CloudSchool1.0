package com.CloudSchool.dao;

import java.util.Map;

import com.CloudSchool.domain.Workinfo;

public interface WorkinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workinfo record);

    int insertSelective(Workinfo record);

    Workinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workinfo record);

    int updateByPrimaryKey(Workinfo record);
    
    //添加作业题目
    int insertListByMap(Map<String, Object> obj);
}