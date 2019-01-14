package com.CloudSchool.dao;

import com.CloudSchool.domain.GkWjcs;

public interface GkWjcsMapper {
    int deleteByPrimaryKey(Integer wjcsId);

    int insert(GkWjcs record);

    int insertSelective(GkWjcs record);

    GkWjcs selectByPrimaryKey(Integer wjcsId);

    int updateByPrimaryKeySelective(GkWjcs record);

    int updateByPrimaryKey(GkWjcs record);
}