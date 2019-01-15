package com.CloudSchool.domain.statistics;
/**
 * 统计题目扩展类
 * @author leerui
 *
 */
public class TopicVo {
	private Integer tId;//题目编号
	private Integer recordId;//题目编号
	private Integer knowledagePointId;//知识点id
	private String knowledagePointName;//知识点名称
	private String topicName;//题目名称  上机题为题目名称 其他的题目为题目内容
	private Double topicTotalScore;//题目总分
	private Double topicScore;//题目得分
	private Integer topicTypeId;//题目类型编号
	private String topicTypeName;//题目类型名称
	private Integer topicNo;//序号
	private Integer topicExamdotId;//考点类型
	private Double topicRate;//得分率
	
	
	
	public TopicVo() {
		topicScore = 0.0;
		topicTotalScore = 0.0;
	}
	public Double getTopicRate() {
		return topicRate;
	}
	public void setTopicRate(Double topicRate) {
		this.topicRate = topicRate;
	}
	public Integer getKnowledagePointId() {
		return knowledagePointId;
	}
	public void setKnowledagePointId(Integer knowledagePointId) {
		this.knowledagePointId = knowledagePointId;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public String getKnowledagePointName() {
		return knowledagePointName;
	}
	public void setKnowledagePointName(String knowledagePointName) {
		this.knowledagePointName = knowledagePointName;
	}
	public Double getTopicTotalScore() {
		return topicTotalScore;
	}
	public void setTopicTotalScore(Double topicTotalScore) {
		this.topicTotalScore = topicTotalScore;
		topicRate = this.topicScore/this.topicTotalScore;
	}
	public Double getTopicScore() {
		return topicScore;
	}
	public void setTopicScore(Double topicScore) {
		this.topicScore = topicScore;
		topicRate = this.topicScore/this.topicTotalScore;
	}
	public Integer getTopicTypeId() {
		return topicTypeId;
	}
	public void setTopicTypeId(Integer topicTypeId) {
		this.topicTypeId = topicTypeId;
	}
	public String getTopicTypeName() {
		return topicTypeName;
	}
	public void setTopicTypeName(String topicTypeName) {
		this.topicTypeName = topicTypeName;
	}
	public Integer getTopicNo() {
		return topicNo;
	}
	public void setTopicNo(Integer topicNo) {
		this.topicNo = topicNo;
	}
	public Integer getTopicExamdotId() {
		return topicExamdotId;
	}
	public void setTopicExamdotId(Integer topicExamdotId) {
		this.topicExamdotId = topicExamdotId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
}
