package com.CloudSchool.dao;

import com.CloudSchool.domain.Testtype;

public interface TesttypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testtype record);

    int insertSelective(Testtype record);

    Testtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testtype record);

    int updateByPrimaryKey(Testtype record);
}