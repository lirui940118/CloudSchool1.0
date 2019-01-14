package com.CloudSchool.domain.zjfvo;

import java.util.List;

import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.CqjStudent;

public class TeacherAdminStu {
	private Integer cid;
	private String cname;
	private List<CqjStudent> list;
	
	
	public String getCname() {
		return cname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<CqjStudent> getList() {
		return list;
	}
	public void setList(List<CqjStudent> list) {
		this.list = list;
	}
}
