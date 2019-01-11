package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjParentsStudent;

public interface CqjParentsStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CqjParentsStudent record);

    int insertSelective(CqjParentsStudent record);

    CqjParentsStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CqjParentsStudent record);

    int updateByPrimaryKey(CqjParentsStudent record);
}