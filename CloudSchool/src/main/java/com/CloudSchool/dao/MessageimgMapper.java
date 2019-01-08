package com.CloudSchool.dao;

import com.CloudSchool.domain.Messageimg;

public interface MessageimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Messageimg record);

    int insertSelective(Messageimg record);

    Messageimg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messageimg record);

    int updateByPrimaryKey(Messageimg record);
}