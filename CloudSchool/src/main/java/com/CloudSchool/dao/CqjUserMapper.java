package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
    //分页查询用户信息
    List<CqjUser> pageUser(@Param("filtrate")String filtrate,@Param("cur")Integer cur,@Param("pageSize")Integer pageSize);
    int queryCunt(String filtrate);
    //查询职员
    List<CqjUser> queryStaff();
    //查询家长
    List<CqjUser> queryParents();
    //查询学员
    List<CqjUser> queryStduents();
}