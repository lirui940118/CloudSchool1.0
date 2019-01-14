package com.CloudSchool.dao;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjRoleModule;

public interface CqjRoleModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CqjRoleModule record);

    int insertSelective(CqjRoleModule record);

    CqjRoleModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CqjRoleModule record);

    int updateByPrimaryKey(CqjRoleModule record);
    
    int deleteByRoleId(Integer roleid);
    
    int addByRoleIdAndModuleid(@Param("roleid")Integer roleid,@Param("result")String[] result);
}