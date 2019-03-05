package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 班级的排课计划与课程进度-tzx
 * @author TZX
 *
 */
public class ClazzPlan {

    private Integer id;

	private String cname;

    private Integer courserid;

	private String coursername;

    private Integer period;

    private Integer tid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCourserid() {
		return courserid;
	}

	public void setCourserid(Integer courserid) {
		this.courserid = courserid;
	}

	public String getCoursername() {
		return coursername;
	}

	public void setCoursername(String coursername) {
		this.coursername = coursername;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
    
    
}