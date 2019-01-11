package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjStudent;

public interface CqjStudentMapper {
    int deleteByPrimaryKey(Integer studentid);

    int insert(CqjStudent record);

    int insertSelective(CqjStudent record);

    CqjStudent selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(CqjStudent record);

    int updateByPrimaryKey(CqjStudent record);
}