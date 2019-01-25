package com.CloudSchool.domain.statistics;
/**
 * 上报给教员的知识点
 * @author leerui
 *
 */
public class KnowledgePointUpVO {
	private Integer courseId;//课程id
	private String courseName;//课程名称
	private Integer sectionId;//章节id
	private String sectionName;//章节名称
	private Integer knowledagepointId;//知识点id
	private String knowledagepointName;//知识点名称
	private Integer count;//上报数量
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Integer getKnowledagepointId() {
		return knowledagepointId;
	}
	public void setKnowledagepointId(Integer knowledagepointId) {
		this.knowledagepointId = knowledagepointId;
	}
	public String getKnowledagepointName() {
		return knowledagepointName;
	}
	public void setKnowledagepointName(String knowledagepointName) {
		this.knowledagepointName = knowledagepointName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
