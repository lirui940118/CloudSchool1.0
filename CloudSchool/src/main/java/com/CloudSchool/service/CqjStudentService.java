package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjStudent;

public interface CqjStudentService {
	//gk通过id查询所在班级所有学生
	public List<CqjStudent> queryTongXueByUserid(Integer uid);
	//查询学员信息
	public CqjStudent queryStudentInfoBySid(Integer sId);
}
