package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjRoleModule;

public interface CqjRoleModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CqjRoleModule record);

    int insertSelective(CqjRoleModule record);

    CqjRoleModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CqjRoleModule record);

    int updateByPrimaryKey(CqjRoleModule record);
}