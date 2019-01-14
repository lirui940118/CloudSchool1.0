package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjStaff;

public interface CqjStaffMapper {
    int deleteByPrimaryKey(Integer staffid);

    int insert(CqjStaff record);

    int insertSelective(CqjStaff record);

    CqjStaff selectByPrimaryKey(Integer staffid);

    int updateByPrimaryKeySelective(CqjStaff record);

    int updateByPrimaryKey(CqjStaff record);
    
    //根据班级id查询到班主任的员工id  在根据员工id来查询班主任的信息
    public CqjStaff queryByclazzid(Integer clazzid);
    
    //根据员工id查询员工对象
    public CqjStaff queryBytid(Integer tid);
}