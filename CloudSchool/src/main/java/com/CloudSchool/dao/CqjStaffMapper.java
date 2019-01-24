package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.statistics.StaffBaseVO;

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
    
    
    //write by lirui 查询员工基本信息和所能教学的科目
    public StaffBaseVO queryStaffBaseVOBySid(Integer staffId);
}