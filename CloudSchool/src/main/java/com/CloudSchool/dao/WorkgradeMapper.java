package com.CloudSchool.dao;

import com.CloudSchool.domain.Workgrade;

public interface WorkgradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workgrade record);

    int insertSelective(Workgrade record);

    Workgrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workgrade record);

    int updateByPrimaryKey(Workgrade record);
    
    int inserStuScore(Workgrade obj);
}