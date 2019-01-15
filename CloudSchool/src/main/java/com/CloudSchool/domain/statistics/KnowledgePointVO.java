package com.CloudSchool.domain.statistics;
/**
 * 知识点扩展类
 * @author leerui
 *
 */

import java.util.List;

public class KnowledgePointVO {
	//知识点所对应的题目集合
	private List<TopicVo> topicList;
	//知识点id
	private Integer knowledagePointId;
	//知识点题目总得分
	private Double knowledagePointTopicTotalScore;
	//知识点题目总分
	private Double knowledagePointTopicScore;
	//理解题目总得分
	private Double understandTopicScore;
	//理解知识点题目总分
	private Double understandTopicTotalScore;
	//识记题目总得分
	private Double memorizationTopicScore;
	//识记知识点题目总分
	private Double memorizationTopicTotalScore;
	
	
	//重写构造函数
	public KnowledgePointVO() {
		knowledagePointTopicTotalScore = 0.0;
		knowledagePointTopicScore = 0.0;
		understandTopicScore = 0.0;
		understandTopicTotalScore = 0.0;
		memorizationTopicScore = 0.0;
		memorizationTopicTotalScore = 0.0;
	}
	public List<TopicVo> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<TopicVo> topicList) {
		this.topicList = topicList;
	}
	public Integer getKnowledagePointId() {
		return knowledagePointId;
	}
	public void setKnowledagePointId(Integer knowledagePointId) {
		this.knowledagePointId = knowledagePointId;
	}
	public Double getKnowledagePointTopicTotalScore() {
		return knowledagePointTopicTotalScore;
	}
	public void setKnowledagePointTopicTotalScore(Double knowledagePointTopicTotalScore) {
		this.knowledagePointTopicTotalScore = knowledagePointTopicTotalScore;
	}
	public Double getKnowledagePointTopicScore() {
		return knowledagePointTopicScore;
	}
	public void setKnowledagePointTopicScore(Double knowledagePointTopicScore) {
		this.knowledagePointTopicScore = knowledagePointTopicScore;
	}
	public Double getUnderstandTopicScore() {
		return understandTopicScore;
	}
	public void setUnderstandTopicScore(Double understandTopicScore) {
		this.understandTopicScore = understandTopicScore;
	}
	public Double getUnderstandTopicTotalScore() {
		return understandTopicTotalScore;
	}
	public void setUnderstandTopicTotalScore(Double understandTopicTotalScore) {
		this.understandTopicTotalScore = understandTopicTotalScore;
	}
	public Double getMemorizationTopicScore() {
		return memorizationTopicScore;
	}
	public void setMemorizationTopicScore(Double memorizationTopicScore) {
		this.memorizationTopicScore = memorizationTopicScore;
	}
	public Double getMemorizationTopicTotalScore() {
		return memorizationTopicTotalScore;
	}
	public void setMemorizationTopicTotalScore(Double memorizationTopicTotalScore) {
		this.memorizationTopicTotalScore = memorizationTopicTotalScore;
	}
	
	
}
