package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.statistics.KnowledgePointUpVO;

public interface LrKnowledagepointTeacherService {
	//劣势知识点上报
	public Integer submitBadKnowledage(Integer courseId,Integer sId,Integer KnowledagepointId);
	//查询该教员知识点的上报情况
    public List<KnowledgePointUpVO> queryAllKnowledagepointByStaffId(Integer staffId);
}
