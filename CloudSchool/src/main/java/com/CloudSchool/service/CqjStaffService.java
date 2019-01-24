package com.CloudSchool.service;

import com.CloudSchool.domain.statistics.StaffBaseVO;

public interface CqjStaffService {
	//write by lirui 查询员工基本信息和所能教学的科目
    public StaffBaseVO queryStaffBaseVOBySid(Integer staffId);
}
