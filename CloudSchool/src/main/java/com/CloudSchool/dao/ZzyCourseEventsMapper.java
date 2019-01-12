package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyCourseEvents;

public interface ZzyCourseEventsMapper {
    int insert(ZzyCourseEvents record);

    int insertSelective(ZzyCourseEvents record);
}