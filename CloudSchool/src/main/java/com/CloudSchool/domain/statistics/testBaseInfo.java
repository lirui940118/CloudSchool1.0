package com.CloudSchool.domain.statistics;
/**
 * 考试基础数据（学员一次考试的基本信息）
 * @author leerui
 *
 */

import javax.xml.crypto.Data;

public class testBaseInfo {
	private String testName;//考试名称
	private String startTime;//考试开始时间
	private String endTime;//考试结束时间
	private Double testScore;//考试得分
	private Double testTotalScore;//开始总分
	private String studentName;//学员名称
	private String studentNo;//学员学号
	private String gradeName;//年级名称
	private String ClazzName;//班级名称
	private String classroomName;//教室名称
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Double getTestScore() {
		return testScore;
	}
	public void setTestScore(Double testScore) {
		this.testScore = testScore;
	}
	public Double getTestTotalScore() {
		return testTotalScore;
	}
	public void setTestTotalScore(Double testTotalScore) {
		this.testTotalScore = testTotalScore;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getClazzName() {
		return ClazzName;
	}
	public void setClazzName(String clazzName) {
		ClazzName = clazzName;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	
	
}
