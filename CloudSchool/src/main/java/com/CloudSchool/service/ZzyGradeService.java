package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyGrade;

public interface ZzyGradeService {
	//查询该学员所读过的年级 write by lirui
	public List<ZzyGrade> queryGradeListBySid(Integer sId);
	//查询该学员当前在读年级
	public ZzyGrade queryCurrentGradeBySid(Integer sId);
}