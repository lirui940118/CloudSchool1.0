package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.Participateteststu;
import com.CloudSchool.domain.statistics.TestInfo;
import com.CloudSchool.domain.statistics.testBaseInfo;
import com.CloudSchool.domain.statistics.testVO;

public interface TestGradeService {
	public List<testVO> querySimStudentTestGradeBySid(Integer sId,Integer gId);
	
	public TestInfo queryAllKnowledagePointBySidAndtId(Integer sId,Integer tId);
	
	public testBaseInfo queryTestBaseInfoBySidAndtId(Integer sId,Integer tId);
	
	public int testCorrect(Participateteststu obj);
}
