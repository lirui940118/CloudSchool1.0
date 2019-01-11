package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjParents;

public interface CqjParentsMapper {
    int deleteByPrimaryKey(Integer parentsid);

    int insert(CqjParents record);

    int insertSelective(CqjParents record);

    CqjParents selectByPrimaryKey(Integer parentsid);

    int updateByPrimaryKeySelective(CqjParents record);

    int updateByPrimaryKey(CqjParents record);
}