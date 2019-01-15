package com.CloudSchool.domain.zjfvo;

import com.CloudSchool.domain.Workinstance;

public class WorkPublishParam {
	private Workinstance obj;
	private Integer wid;
	private Integer[] sid;
	public Workinstance getObj() {
		return obj;
	}
	public void setObj(Workinstance obj) {
		this.obj = obj;
	}
	private Integer[] cid;
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public Integer[] getSid() {
		return sid;
	}
	public void setSid(Integer[] sid) {
		this.sid = sid;
	}
	public Integer[] getCid() {
		return cid;
	}
	public void setCid(Integer[] cid) {
		this.cid = cid;
	}

}
