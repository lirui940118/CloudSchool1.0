package com.CloudSchool.service;

import com.CloudSchool.domain.CqjStudent;

public interface CqjStudentService {
	//查询学员信息
	public CqjStudent queryStudentInfoBySid(Integer sId);
}
