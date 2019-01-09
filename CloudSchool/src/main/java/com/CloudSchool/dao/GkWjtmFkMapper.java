package com.CloudSchool.dao;

import com.CloudSchool.domain.GkWjtmFk;

public interface GkWjtmFkMapper {
    int deleteByPrimaryKey(Integer fkId);

    int insert(GkWjtmFk record);

    int insertSelective(GkWjtmFk record);

    GkWjtmFk selectByPrimaryKey(Integer fkId);

    int updateByPrimaryKeySelective(GkWjtmFk record);

    int updateByPrimaryKey(GkWjtmFk record);
}