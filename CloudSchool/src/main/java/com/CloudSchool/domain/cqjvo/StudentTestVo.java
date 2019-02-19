package com.CloudSchool.domain.cqjvo;

import java.io.Serializable;

public class StudentTestVo  implements Serializable {
	//学生id
	int sid;
	//试卷总分数
	double testSumScore;
	//考试得分
	double testScore;
	//考试名称
	String testname;
	//考试类型
	String testTypeName;
	//试卷编号
	int testid;
	//试卷类型编号
	int mid;
	//考试次数
	int tc;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getTc() {
		return tc;
	}
	public void setTc(int tc) {
		this.tc = tc;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public double getTestSumScore() {
		return testSumScore;
	}
	public void setTestSumScore(double testSumScore) {
		this.testSumScore = testSumScore;
	}
	public double getTestScore() {
		return testScore;
	}
	public void setTestScore(double testScore) {
		this.testScore = testScore;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getTestTypeName() {
		return testTypeName;
	}
	public void setTestTypeName(String testTypeName) {
		this.testTypeName = testTypeName;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	
	
}
