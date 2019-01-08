package com.CloudSchool.dao;

import com.CloudSchool.domain.Testmodule;

public interface TestmoduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testmodule record);

    int insertSelective(Testmodule record);

    Testmodule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testmodule record);

    int updateByPrimaryKey(Testmodule record);
}