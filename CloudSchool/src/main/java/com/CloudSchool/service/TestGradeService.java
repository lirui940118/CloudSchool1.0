package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.statistics.testVO;

public interface TestGradeService {
	public List<testVO> querySimStudentTestGradeBySid(Integer sId,Integer gId);
}
