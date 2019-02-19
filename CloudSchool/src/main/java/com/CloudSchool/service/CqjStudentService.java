package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.Studentupgrade;

public interface CqjStudentService {
	// 查询学员信息
	public CqjStudent queryStudentInfoBySid(Integer sId);

	public int addStudents(List<CqjStudent> student);
	
	 List<CqjStudent> queryStudetnTestByCid(Integer cid,Integer gid);
	 
	 int addStudentUpGrade(List<Studentupgrade> Studentupgrade,Integer cid);

}
