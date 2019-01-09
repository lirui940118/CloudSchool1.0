package com.CloudSchool.domain;

import java.util.List;

public class ClazzInfo extends Clazz {
	private List<Clazzstudent> slist;
	private List<Clazzcourseteacher> tlist;
	public List<Clazzstudent> getSlist() {
		return slist;
	}
	public void setSlist(List<Clazzstudent> slist) {
		this.slist = slist;
	}
	public List<Clazzcourseteacher> getTlist() {
		return tlist;
	}
	public void setTlist(List<Clazzcourseteacher> tlist) {
		this.tlist = tlist;
	}
	
}
