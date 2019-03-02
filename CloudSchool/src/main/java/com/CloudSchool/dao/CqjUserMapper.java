package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.CqjStudent;
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
    //批量分配学生的系统登录账号user
    int insertAll(List<CqjUser> u);
    //gk通过userid判断是否为学生，if是，则带出当前班级id插入访谈记录表 -->
	Integer queryCidByUserid(Integer userid);
	//批量分配职工的系统登录账号user
	int addStaffUser(List<CqjStaff> staff);
    
}