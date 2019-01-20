package com.CloudSchool.domain.statistics;
/**
 * 劣势知识点
 * @author leerui
 *
 */
public class BadTopicVO {
	private String courseName;//课程名称
	private String sectionName;//章节名称
	private String knowledageName;//知识点名称
	private Integer knowledageId;//知识点id
	private Double score;//得分（总）所有题目
	private Double totalScore;//总分 （总）所有题目
	private Integer totalCount;//题目总数 数量
	private Double rate;//正确率
	private Integer studentId;//所查询的学员id
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getKnowledageName() {
		return knowledageName;
	}
	public void setKnowledageName(String knowledageName) {
		this.knowledageName = knowledageName;
	}
	public Integer getKnowledageId() {
		return knowledageId;
	}
	public void setKnowledageId(Integer knowledageId) {
		this.knowledageId = knowledageId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	
}
