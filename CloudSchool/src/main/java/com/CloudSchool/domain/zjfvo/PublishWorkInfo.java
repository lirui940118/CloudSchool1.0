package com.CloudSchool.domain.zjfvo;

import com.CloudSchool.domain.Workmould;

public class PublishWorkInfo {
	private Integer id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String startTime;
	private String endTime;
	private String cName;
	private Integer wStatus;
	private Integer wType;
	private Integer cid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
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
