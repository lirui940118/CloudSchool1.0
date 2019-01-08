package com.CloudSchool.dao;

import com.CloudSchool.domain.Workinstance;

public interface WorkinstanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workinstance record);

    int insertSelective(Workinstance record);

    Workinstance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workinstance record);

    int updateByPrimaryKey(Workinstance record);
}