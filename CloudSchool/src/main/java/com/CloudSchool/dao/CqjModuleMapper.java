package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjModule;

public interface CqjModuleMapper {
    int deleteByPrimaryKey(Integer moduleid);

    int insert(CqjModule record);

    int insertSelective(CqjModule record);

    CqjModule selectByPrimaryKey(Integer moduleid);

    int updateByPrimaryKeySelective(CqjModule record);

    int updateByPrimaryKey(CqjModule record);
    
    List<CqjModule> queryByRoleidandPositionid(@Param("roleid")Integer roleid,@Param("positionid")Integer positionid);
    List<CqjModule> queryAllModuleByRoleid(Integer roleid);
    List<CqjModule> queryAllInfoModuleByPositionid(Integer positionid);
    List<CqjModule> queryInfoModuleByPositionid(Integer positionid);
    List<CqjModule> queryModule();
    List<CqjModule> queryInfoModule();
}