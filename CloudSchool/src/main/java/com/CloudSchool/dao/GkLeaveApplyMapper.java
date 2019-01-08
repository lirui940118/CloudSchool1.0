package com.CloudSchool.dao;

import com.CloudSchool.domain.GkLeaveApply;

public interface GkLeaveApplyMapper {
    int deleteByPrimaryKey(Integer qjsqId);

    int insert(GkLeaveApply record);

    int insertSelective(GkLeaveApply record);

    GkLeaveApply selectByPrimaryKey(Integer qjsqId);

    int updateByPrimaryKeySelective(GkLeaveApply record);

    int updateByPrimaryKey(GkLeaveApply record);
}