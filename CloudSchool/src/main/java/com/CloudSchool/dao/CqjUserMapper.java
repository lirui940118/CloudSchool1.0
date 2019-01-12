package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjUser;

public interface CqjUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(CqjUser record);

    int insertSelective(CqjUser record);

    CqjUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(CqjUser record);

    int updateByPrimaryKey(CqjUser record);
    //登录 通过账号密码 获得用户的信息
    CqjUser login(String username,String password);
    //通过职位编号获得用户权限可以访问的班级
    String[] queryClazzByPositionid(Integer positionid);
    //通过userid 获取用户的信息
    CqjUser queryByUserid(Integer userid);
}