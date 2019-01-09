package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjModule;

public interface CqjModuleMapper {
    int deleteByPrimaryKey(Integer moduleid);

    int insert(CqjModule record);

    int insertSelective(CqjModule record);

    CqjModule selectByPrimaryKey(Integer moduleid);

    int updateByPrimaryKeySelective(CqjModule record);

    int updateByPrimaryKey(CqjModule record);
}