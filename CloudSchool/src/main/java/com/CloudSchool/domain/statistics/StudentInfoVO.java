package com.CloudSchool.domain.statistics;

import java.util.List;

public class StudentInfoVO implements Comparable<StudentInfoVO>{
	private Integer studentId;//学员id
	private String studentName;//名称
	private String no;//学号编号
	private List<testVO> testList;//多次考试成绩
	private Double averageScore;//平均分
	private Integer averageNo;//平均分名次
	
	
	
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<testVO> getTestList() {
		return testList;
	}
	public void setTestList(List<testVO> testList) {
		this.testList = testList;
	}
	public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	
	
	
	public Integer getAverageNo() {
		return averageNo;
	}
	public void setAverageNo(Integer averageNo) {
		this.averageNo = averageNo;
	}



	//排序类型（无实际意义，只是用来排序） 1 为第一场考试，2为第二场考试 -1为平均分
	public static Integer sortType = -1;
	@Override
	public int compareTo(StudentInfoVO o) {
		
		if(sortType == -1) {
			//平均分排序
			if(this.averageScore -o.averageScore >0) {
			return -1;
			}else {
				return 1;
			}
		}else {//场次排序
			if(this.testList.get(sortType).getStudentScore()-o.testList.get(sortType).getStudentScore()>0) {
				return -1;
			}else {
				return 1;
			}
		}
	}
	
}
