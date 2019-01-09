package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjRole;

public interface CqjRoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(CqjRole record);

    int insertSelective(CqjRole record);

    CqjRole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(CqjRole record);

    int updateByPrimaryKey(CqjRole record);
}