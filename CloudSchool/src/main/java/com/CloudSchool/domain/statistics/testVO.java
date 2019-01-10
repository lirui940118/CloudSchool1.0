package com.CloudSchool.domain.statistics;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 学员首页查询
 * @author leerui
 *
 */



public class testVO {
	private String TestName;//考试名称
	private String TestTsime;//考试时间（考试结束时间）
	private double StudentScore;//学员得分
	private double TotalScore;//试卷总分
	private double studentScore100;//学员百分制得分
	public String getTestName() {
		return TestName;
	}
	public void setTestName(String testName) {
		TestName = testName;
	}
	
	
	public String getTestTsime() {
		return TestTsime;
	}
	public void setTestTsime(String testTsime) {
		TestTsime = testTsime;
	}
	public double getStudentScore() {
		return StudentScore;
	}
	public void setStudentScore(double studentScore) {
		StudentScore = studentScore;
	}
	public double getTotalScore() {
		return TotalScore;
	}
	public void setTotalScore(double totalScore) {
		TotalScore = totalScore;
	}
	public double getStudentScore100() {
		return studentScore100;
	}
	public void setStudentScore100(double studentScore100) {
		this.studentScore100 = studentScore100;
	}
	
	
}
