package com.CloudSchool.dao;

import com.CloudSchool.domain.Missionhistory;

public interface MissionhistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Missionhistory record);

    int insertSelective(Missionhistory record);

    Missionhistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Missionhistory record);

    int updateByPrimaryKey(Missionhistory record);
}