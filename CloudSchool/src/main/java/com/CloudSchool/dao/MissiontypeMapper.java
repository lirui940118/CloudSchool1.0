package com.CloudSchool.dao;

import com.CloudSchool.domain.Missiontype;

public interface MissiontypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Missiontype record);

    int insertSelective(Missiontype record);

    Missiontype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Missiontype record);

    int updateByPrimaryKey(Missiontype record);
}