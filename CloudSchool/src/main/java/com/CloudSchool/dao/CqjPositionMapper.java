package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjPosition;

public interface CqjPositionMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(CqjPosition record);

    int insertSelective(CqjPosition record);

    CqjPosition selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(CqjPosition record);

    int updateByPrimaryKey(CqjPosition record);
}