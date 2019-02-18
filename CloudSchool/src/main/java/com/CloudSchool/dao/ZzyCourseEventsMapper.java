package com.CloudSchool.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ZzyCourseEvents;

public interface ZzyCourseEventsMapper {
    int insert(ZzyCourseEvents record);

    int insertSelective(ZzyCourseEvents record);
    
    public Integer filtrateEvebts(@Param("time")Date time,@Param("user1")int user1,@Param("cid")int cid);
}