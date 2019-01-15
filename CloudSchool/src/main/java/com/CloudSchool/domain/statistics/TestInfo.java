package com.CloudSchool.domain.statistics;
/**
 * 一次考试数据分析
 * @author leerui
 *
 */

import java.util.List;


public class TestInfo {
	//知识点分类下的题目集合
	List<KnowledgePointVO> KnowledgePointList;
	//上机题目集合
	private List<TopicVo> applicationTopicList;
	public List<KnowledgePointVO> getKnowledgePointList() {
		return KnowledgePointList;
	}
	public void setKnowledgePointList(List<KnowledgePointVO> knowledgePointList) {
		KnowledgePointList = knowledgePointList;
	}
	public List<TopicVo> getApplicationTopicList() {
		return applicationTopicList;
	}
	public void setApplicationTopicList(List<TopicVo> applicationTopicList) {
		this.applicationTopicList = applicationTopicList;
	}
	
	
	
	
	
	
}
