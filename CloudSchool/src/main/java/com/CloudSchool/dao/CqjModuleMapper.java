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
    //通过角色编号和职位编号查出所有能用的模块
    List<CqjModule> queryByRoleidandPositionid(@Param("roleid")Integer roleid,@Param("positionid")Integer positionid);
    //通过角色id查出能用的模块
    List<CqjModule> queryAllModuleByRoleid(Integer roleid);
    //通过职位id查出能用的模块
    List<CqjModule> queryAllInfoModuleByPositionid(Integer positionid);
    //通过职位id查出数据模块
    List<CqjModule> queryInfoModuleByPositionid(Integer positionid);
    //查询出所有的非数据模块查出
    List<CqjModule> queryModule();
    //查出所有的模块包括数据模块
    List<CqjModule> queryInfoModule();
}