package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyCourse;

public interface ZzyCourseMapper {
    int insert(ZzyCourse record);

    int insertSelective(ZzyCourse record);
}