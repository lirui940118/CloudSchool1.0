package com.CloudSchool.domain.statistics;
/**
 * 教员
 * @author leerui
 *
 */
public class StaffVO {
	//教员id
	private Integer staffId;
	//教员名称
	private String staffName;
	//教员年龄
	private Integer staffAge;
	//评价分数
	private Double staffScore;
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
	public Integer getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}
	public Double getStaffScore() {
		return staffScore;
	}
	public void setStaffScore(Double staffScore) {
		this.staffScore = staffScore;
	}
	
}
