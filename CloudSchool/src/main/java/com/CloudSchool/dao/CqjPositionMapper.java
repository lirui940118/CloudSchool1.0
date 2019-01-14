package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import com.CloudSchool.domain.CqjPosition;

public interface CqjPositionMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(CqjPosition record);

    int insertSelective(CqjPosition record);

    CqjPosition selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(CqjPosition record);

    int updateByPrimaryKey(CqjPosition record);
    List<CqjPosition> qeuryAllposition();

}