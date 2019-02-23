package com.CloudSchool.domain.statistics;
/**
 * 教员
 * @author leerui
 *
 */
public class StaffVO implements Comparable{
	//教员id
	private Integer staffId;
	//教员名称
	private String staffName;
	//教员入职时间
	private String staffGoingTime;
	//教员年龄
	private Integer staffAge;
	//评价分数
	private Integer staffScore;
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
	public Integer getStaffScore() {
		return staffScore;
	}
	public void setStaffScore(Integer staffScore) {
		this.staffScore = staffScore;
	}
	//重写排序
	@Override
	public int compareTo(Object obj) {
		StaffVO staffVO = (StaffVO) obj;
		
		return staffVO.staffScore - this.staffScore;
	}
	public String getStaffGoingTime() {
		return staffGoingTime;
	}
	public void setStaffGoingTime(String staffGoingTime) {
		this.staffGoingTime = staffGoingTime;
	}
	
}
