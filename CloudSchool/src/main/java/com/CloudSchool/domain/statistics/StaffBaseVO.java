package com.CloudSchool.domain.statistics;
/**
 * 教员基础信息
 * 教员首页
 * @author leerui
 *
 */

import java.util.List;

public class StaffBaseVO {
	private Integer staffId;//员工id
	private String staffName;//员工名称
	private String staffNum;//员工工号
	private Integer staffAge;//年龄
	private String startTime;//入职时间
	private String endTime;//离职时间
	private Integer staffStatue;//在职状态
	private Integer positionId;//职位id
	private String url;//头像地址
	List<CourseVO> courseList;
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public Integer getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
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
	public Integer getStaffStatue() {
		return staffStatue;
	}
	public void setStaffStatue(Integer staffStatue) {
		this.staffStatue = staffStatue;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<CourseVO> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<CourseVO> courseList) {
		this.courseList = courseList;
	}
	
}
