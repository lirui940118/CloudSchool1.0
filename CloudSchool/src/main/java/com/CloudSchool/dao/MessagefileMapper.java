package com.CloudSchool.dao;

import com.CloudSchool.domain.Messagefile;

public interface MessagefileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Messagefile record);

    int insertSelective(Messagefile record);

    Messagefile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messagefile record);

    int updateByPrimaryKey(Messagefile record);
}