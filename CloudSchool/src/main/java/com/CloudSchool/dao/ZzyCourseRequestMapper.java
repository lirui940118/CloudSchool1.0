package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyCourseRequest;

public interface ZzyCourseRequestMapper {
    int insert(ZzyCourseRequest record);

    int insertSelective(ZzyCourseRequest record);
}