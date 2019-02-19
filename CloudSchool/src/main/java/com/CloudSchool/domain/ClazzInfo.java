package com.CloudSchool.domain;

import java.util.List;

public class ClazzInfo extends Clazz {
	private List<CqjStudent> slist;
	private List<Clazzcourseteacher> tlist;
	private List<Integer> userid;
	//操作员的userid
	private Integer uid;
	public List<CqjStudent> getSlist() {
		return slist;
	}
	public void setSlist(List<CqjStudent> slist) {
		this.slist = slist;
	}
	public List<Clazzcourseteacher> getTlist() {
		return tlist;
	}
	public void setTlist(List<Clazzcourseteacher> tlist) {
		this.tlist = tlist;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public List<Integer> getUserid() {
		return userid;
	}
	public void setUserid(List<Integer> userid) {
		this.userid = userid;
	}
	
}
