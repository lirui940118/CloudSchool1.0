package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.CloudSchool.domain.statistics.TestComprehensiveScoreVO;

@Mapper
public interface LrGradeTestScoreMapper {
	//年级统计同一批次下的各个班综合数据
	public List<TestComprehensiveScoreVO> getClazzTestsAvgScoreByPc(String pc);
}
