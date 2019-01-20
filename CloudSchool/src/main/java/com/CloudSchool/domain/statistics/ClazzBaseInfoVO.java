package com.CloudSchool.domain.statistics;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 班级成绩统计基础数据
 * @author leerui
 *
 */
public class ClazzBaseInfoVO {
	private String GradeName;//年级名称
	private String clazzName;//班级名称
	private String majorName;//专业名称
	private Integer courseId;//课程编号
	private String courseName;//课题名称
	private Integer staffId;//员工编号（教员班主任）
	private String staffName;//员工名称
	private Integer isMaster;//是否为班主任
	private Integer isTeacher;//是否为教员
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")//出去
	@DateTimeFormat(pattern="yyyy-MM-dd")//进来
	private Date startTime; //课程开始时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")//出去
	@DateTimeFormat(pattern="yyyy-MM-dd")//进来
	private Date endTime;//课程结束时间1
	
	public String getGradeName() {
		return GradeName;
	}
	public void setGradeName(String gradeName) {
		GradeName = gradeName;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
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
	public Integer getIsMaster() {
		return isMaster;
	}
	public void setIsMaster(Integer isMaster) {
		this.isMaster = isMaster;
	}
	public Integer getIsTeacher() {
		return isTeacher;
	}
	public void setIsTeacher(Integer isTeacher) {
		this.isTeacher = isTeacher;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	

}
