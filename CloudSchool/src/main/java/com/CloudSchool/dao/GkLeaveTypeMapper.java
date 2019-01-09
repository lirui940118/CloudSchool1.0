package com.CloudSchool.dao;

import com.CloudSchool.domain.GkLeaveType;

public interface GkLeaveTypeMapper {
    int deleteByPrimaryKey(Integer qjTypeId);

    int insert(GkLeaveType record);

    int insertSelective(GkLeaveType record);

    GkLeaveType selectByPrimaryKey(Integer qjTypeId);

    int updateByPrimaryKeySelective(GkLeaveType record);

    int updateByPrimaryKey(GkLeaveType record);
}