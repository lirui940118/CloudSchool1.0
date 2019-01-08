package com.CloudSchool.dao;

import com.CloudSchool.domain.Teachermission;

public interface TeachermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teachermission record);

    int insertSelective(Teachermission record);

    Teachermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teachermission record);

    int updateByPrimaryKey(Teachermission record);
}