package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjPositionModule;

public interface CqjPositionModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CqjPositionModule record);

    int insertSelective(CqjPositionModule record);

    CqjPositionModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CqjPositionModule record);

    int updateByPrimaryKey(CqjPositionModule record);
}