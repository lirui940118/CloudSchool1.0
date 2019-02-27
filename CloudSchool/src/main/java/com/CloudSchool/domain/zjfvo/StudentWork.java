package com.CloudSchool.domain.zjfvo;

public class StudentWork {
	private Integer workmouldid;
	private String name;
	private String startTime;
	private String endTime;
	private Integer isCorrect;
	private Integer wStatus;
	public Integer getwStatus() {
		return wStatus;
	}
	public void setwStatus(Integer wStatus) {
		this.wStatus = wStatus;
	}
	public Integer getWorkmouldid() {
		return workmouldid;
	}
	public void setWorkmouldid(Integer workmouldid) {
		this.workmouldid = workmouldid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Integer isCorrect) {
		this.isCorrect = isCorrect;
	}

}
