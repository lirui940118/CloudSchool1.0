package com.CloudSchool.dao;

import com.CloudSchool.domain.GkInterview;

public interface GkInterviewMapper {
    int deleteByPrimaryKey(Integer ftId);

    int insert(GkInterview record);

    int insertSelective(GkInterview record);

    GkInterview selectByPrimaryKey(Integer ftId);

    int updateByPrimaryKeySelective(GkInterview record);

    int updateByPrimaryKey(GkInterview record);
}