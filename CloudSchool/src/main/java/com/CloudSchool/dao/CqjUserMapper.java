package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjUser;

public interface CqjUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(CqjUser record);

    int insertSelective(CqjUser record);

    CqjUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(CqjUser record);

    int updateByPrimaryKey(CqjUser record);
    
    CqjUser login(String username,String password);
    String[] queryClazzByPositionid(Integer positionid);
}