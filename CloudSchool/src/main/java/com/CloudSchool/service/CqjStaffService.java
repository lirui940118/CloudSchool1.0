package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.statistics.StaffBaseVO;

public interface CqjStaffService {
	//write by lirui 查询员工基本信息和所能教学的科目
    public StaffBaseVO queryStaffBaseVOBySid(Integer staffId);
    //write by lirui 查询员工能力（雷达图）
    public List<Integer> queryStaffAbility(Integer staffId);
    //查询职工职位id write by lirui
    public Integer queryPositionIdByStaffId(Integer staffId);
}
