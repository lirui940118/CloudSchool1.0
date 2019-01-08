package com.CloudSchool.dao;

import com.CloudSchool.domain.GkLeaveState;

public interface GkLeaveStateMapper {
    int deleteByPrimaryKey(Integer qjStateId);

    int insert(GkLeaveState record);

    int insertSelective(GkLeaveState record);

    GkLeaveState selectByPrimaryKey(Integer qjStateId);

    int updateByPrimaryKeySelective(GkLeaveState record);

    int updateByPrimaryKey(GkLeaveState record);
}