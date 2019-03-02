package com.CloudSchool.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.domain.statistics.BadTopicVO;
import com.CloudSchool.domain.zjfvo.TestInfo;

public interface WtrecordService {
	public int pageSaveClose( Workinstance obj);
	public int studentPublishWork(Workinstance obj);
	//write by lirui 查询学员的劣势知识点 (作业和考试)
    public List<BadTopicVO> queryBadKnowledagePointBySid(Integer sId);
    
    public Wtrecord queryTopicById(Integer id);
    
    public int updateScoreByWidSidTid(Wtrecord obj);
    
    public int testPublish(@RequestBody TestInfo obj);
}
