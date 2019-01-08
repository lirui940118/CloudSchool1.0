package com.CloudSchool.dao;

import com.CloudSchool.domain.Testgrade;

public interface TestgradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testgrade record);

    int insertSelective(Testgrade record);

    Testgrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testgrade record);

    int updateByPrimaryKey(Testgrade record);
}