package com.CloudSchool.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjPositionModule;

public interface CqjPositionModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CqjPositionModule record);

    int insertSelective(CqjPositionModule record);

    CqjPositionModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CqjPositionModule record);

    int updateByPrimaryKey(CqjPositionModule record);
    
    int deleteByPositionId(Integer positionid);
    
    int addByPositionIdAndModuleid(@Param("positionid")Integer positionid,@Param("result")String[] result);
}