package com.CloudSchool.domain.zjfvo;

public class PublishWorkInfo {
	private Integer id;
	private String name;
	private String startTime;
	private String endTime;
	private String cName;
	private Integer wStatus;
	private Integer wType;
	public Integer getwType() {
		return wType;
	}
	public void setwType(Integer wType) {
		this.wType = wType;
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
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Integer getwStatus() {
		return wStatus;
	}
	public void setwStatus(Integer wStatus) {
		this.wStatus = wStatus;
	}

}