package com.CloudSchool.domain.statistics;
/**
 * 学员基础信息 首页显示
 * @author leerui
 *
 */
public class StudentBaseInfoVO {
	private Integer studentId;//主键编号
	private String studentNo;//学员学号
	private String studentName;
	private Integer sex; //sex性别 0男 1女生 
	private Integer studentAge;
	private Integer standby1;//standby1 0在读/1毕业
	private String url;//头像地址
	public Integer getStudentId() {
		return studentId;
	}
	
	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	public Integer getStandby1() {
		return standby1;
	}
	public void setStandby1(Integer standby1) {
		this.standby1 = standby1;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
