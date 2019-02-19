package com.CloudSchool.domain.cqjvo;

public class ProgressInfo {
	Integer cid;
	Integer gid;
	Integer ngid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getNgid() {
		return ngid;
	}
	public void setNgid(Integer ngid) {
		this.ngid = ngid;
	}
	public ProgressInfo() {
		// TODO Auto-generated constructor stub
	}
	public ProgressInfo(Integer cid, Integer gid, Integer ngid) {
		super();
		this.cid = cid;
		this.gid = gid;
		this.ngid = ngid;
	}
	
}
