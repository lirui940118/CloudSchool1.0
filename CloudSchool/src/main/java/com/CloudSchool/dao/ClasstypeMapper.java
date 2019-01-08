package com.CloudSchool.dao;

import com.CloudSchool.domain.Classtype;

public interface ClasstypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classtype record);

    int insertSelective(Classtype record);

    Classtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classtype record);

    int updateByPrimaryKey(Classtype record);
}