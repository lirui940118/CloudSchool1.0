package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyRealtimeClassroom;

public interface ZzyRealtimeClassroomMapper {
    int insert(ZzyRealtimeClassroom record);

    int insertSelective(ZzyRealtimeClassroom record);
}