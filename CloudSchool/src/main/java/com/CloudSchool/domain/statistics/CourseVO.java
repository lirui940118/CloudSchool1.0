package com.CloudSchool.domain.statistics;
/**
 * 开办选老师用
 * @author leerui
 *
 *
 *备注：给开办的list<CouseVO> 第一个元素为班主任教员集合
 */

import java.util.List;

public class CourseVO {
	//课程id
	private Integer courseId;
	//课程名称
	private String courseName;
	//教员集合
	List<StaffVO> staffVOList;
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
	public List<StaffVO> getStaffVOList() {
		return staffVOList;
	}
	public void setStaffVOList(List<StaffVO> staffVOList) {
		this.staffVOList = staffVOList;
	}
	
}
