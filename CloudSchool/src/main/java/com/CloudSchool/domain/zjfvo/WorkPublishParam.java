package com.CloudSchool.domain.zjfvo;

import java.util.List;

import com.CloudSchool.domain.Workinstance;

public class WorkPublishParam {
	private Workinstance obj;
	
	public Workinstance getObj() {
		return obj;
	}
	public void setObj(Workinstance obj) {
		this.obj = obj;
	}
	public List<ClazzAndStuParam> getList() {
		return list;
	}
	public void setList(List<ClazzAndStuParam> list) {
		this.list = list;
	}
	private List<ClazzAndStuParam> list;

}
