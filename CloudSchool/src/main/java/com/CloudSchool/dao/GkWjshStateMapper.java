package com.CloudSchool.dao;

import com.CloudSchool.domain.GkWjshState;

public interface GkWjshStateMapper {
    int deleteByPrimaryKey(Integer wjshStateId);

    int insert(GkWjshState record);

    int insertSelective(GkWjshState record);

    GkWjshState selectByPrimaryKey(Integer wjshStateId);

    int updateByPrimaryKeySelective(GkWjshState record);

    int updateByPrimaryKey(GkWjshState record);
}