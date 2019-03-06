package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.statistics.StaffBaseVO;

public interface CqjStaffService {
    //查询所有员工 龚款
	List<CqjStaff> queryAllYuanGong();
	//write by lirui 查询员工基本信息和所能教学的科目
    public StaffBaseVO queryStaffBaseVOBySid(Integer staffId);
    //write by lirui 查询员工能力（雷达图）
    public List<Integer> queryStaffAbility(Integer staffId);
    //查询职工职位id write by lirui
    public Integer queryPositionIdByStaffId(Integer staffId);
    
    
    //查询一个时间段 所有有空的任课老师（赵举峰）
    List<CqjStaff> queryNullTeach(String time,Integer status);
}
