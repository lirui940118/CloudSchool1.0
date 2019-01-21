package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.statistics.BadTopicVO;

public interface WtrecordService {
	public int pageSaveClose( Workinstance obj);
	public int studentPublishWork(Workinstance obj);
	//write by lirui 查询学员的劣势知识点 (作业和考试)
    public List<BadTopicVO> queryBadKnowledagePointBySid(Integer sId);
}
