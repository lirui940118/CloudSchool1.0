package com.CloudSchool.dao;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ZzyRealtimeClassroom;

public interface ZzyRealtimeClassroomMapper {
    int insert(ZzyRealtimeClassroom record);

    int insertSelective(ZzyRealtimeClassroom record);
    /*学员课堂表现，统计用*/
    Integer queryRealtimeBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId);
}