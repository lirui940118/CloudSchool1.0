package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.CloudSchool.domain.Missionhistory;
@Mapper
public interface MissionhistoryMapper {
	List<Missionhistory> query(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Missionhistory record);

    int insertSelective(Missionhistory record);

    Missionhistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Missionhistory record);

    int updateByPrimaryKey(Missionhistory record);
}