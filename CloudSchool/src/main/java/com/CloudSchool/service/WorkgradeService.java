package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.statistics.WorkGradeVo;

public interface WorkgradeService {
	//作业完成情况
	public List<WorkGradeVo> queryStudentWorkInfoBysIdAndgId(Integer sId,Integer gId);
	//学员作业完成率
    public Double queryStudentWorkTimelyFinishRate(Integer sId,Integer gId);
}
