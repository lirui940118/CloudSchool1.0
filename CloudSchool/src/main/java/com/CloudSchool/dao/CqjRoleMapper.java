package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjRole;

public interface CqjRoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(CqjRole record);

    int insertSelective(CqjRole record);

    CqjRole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(CqjRole record);

    int updateByPrimaryKey(CqjRole record);
    
    List<CqjRole> queryAllRole();
    
}