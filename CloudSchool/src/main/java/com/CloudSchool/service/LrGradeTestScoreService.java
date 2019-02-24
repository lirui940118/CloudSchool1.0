package com.CloudSchool.service;

import java.util.List;


import com.CloudSchool.domain.statistics.TestComprehensiveScoreVO;
public interface LrGradeTestScoreService {
	//年级统计同一批次下的各个班综合数据
	public List<TestComprehensiveScoreVO> getClazzTestsAvgScoreByPc(String pc);
}
