package com.CloudSchool.domain.zjfvo;

import java.awt.dnd.MouseDragGestureRecognizer;

import com.CloudSchool.domain.Workmould;

public class WorkinstanceInfo {
	private Integer pstuid;
	private String studentname;
	private String time;
	private String commitTime;
	private Integer isCorrect;
	private Integer workid;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	private Integer score;
	private Integer sid;
	//作业实例id
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPstuid() {
		return pstuid;
	}
	public void setPstuid(Integer pstuid) {
		this.pstuid = pstuid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}
	public Integer getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Integer isCorrect) {
		this.isCorrect = isCorrect;
	}
	public Integer getWorkid() {
		return workid;
	}
	public void setWorkid(Integer workid) {
		this.workid = workid;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	private String rank;

}
