package com.CloudSchool.domain.statistics;
/**
 * 学员首页查询
 * @author leerui
 *
 */

import javax.xml.crypto.Data;

public class testVO {
	private String TestName;//考试名称
	private Data TestTsime;//考试时间（考试结束时间）
	private double StudentScore;//学员得分
	private double TotalScore;//试卷总分
	private double studentScore100;//学员百分制得分
	public String getTestName() {
		return TestName;
	}
	public void setTestName(String testName) {
		TestName = testName;
	}
	public Data getTestTsime() {
		return TestTsime;
	}
	public void setTestTsime(Data testTsime) {
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
