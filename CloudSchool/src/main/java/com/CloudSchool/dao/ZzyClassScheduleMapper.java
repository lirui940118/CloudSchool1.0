package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyClassSchedule;

public interface ZzyClassScheduleMapper {
    int insert(ZzyClassSchedule record);

    int insertSelective(ZzyClassSchedule record);
}