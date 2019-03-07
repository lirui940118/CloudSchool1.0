package com.CloudSchool.domain.zjfvo;

//学生考试记录
public class StuTestInfo {
	private Integer id;
	private String name;
	private String starttime;
	private String endtime;
	private String user3;
	private Integer clazzstatus;
	private Integer score;
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getClazzstatus() {
		return clazzstatus;
	}
	public void setClazzstatus(Integer clazzstatus) {
		this.clazzstatus = clazzstatus;
	}
	public String getUser3() {
		return user3;
	}
	public void setUser3(String user3) {
		this.user3 = user3;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}
