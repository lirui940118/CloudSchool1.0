package com.CloudSchool.domain.zjfvo;

import java.util.List;

import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.Testinstance;
import com.CloudSchool.domain.Testmodule;
import com.CloudSchool.domain.Wtrecord;

//试卷答题卡
public class TestInfo {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Testinstance  testinstance;
	private Testmodule testmodule;
	public Testinstance getTestinstance() {
		return testinstance;
	}
	public void setTestinstance(Testinstance testinstance) {
		this.testinstance = testinstance;
	}
	public Testmodule getTestmodule() {
		return testmodule;
	}
	public void setTestmodule(Testmodule testmodule) {
		this.testmodule = testmodule;
	}
	public CqjStaff getCqjStaff() {
		return cqjStaff;
	}
	public void setCqjStaff(CqjStaff cqjStaff) {
		this.cqjStaff = cqjStaff;
	}
	
	public List<Testinfo> getList() {
		return list;
	}
	public void setList(List<Testinfo> list) {
		this.list = list;
	}
	private CqjStaff cqjStaff;
	private List<Testinfo> list;

}
