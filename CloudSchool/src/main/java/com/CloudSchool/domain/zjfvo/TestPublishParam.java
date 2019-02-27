package com.CloudSchool.domain.zjfvo;

import java.util.List;

import com.CloudSchool.domain.Participatetestclass;
import com.CloudSchool.domain.Testinstance;

public class TestPublishParam {
	private Testinstance obj;		//考试实例
	private List<TestclassVoParam> clazz;
	public List<TestclassVoParam> getClazz() {
		return clazz;
	}
	public void setClazz(List<TestclassVoParam> clazz) {
		this.clazz = clazz;
	}
	public List<ClazzAndStuParam> getList() {
		return list;
	}
	public void setList(List<ClazzAndStuParam> list) {
		this.list = list;
	}
	private List<ClazzAndStuParam> list;		//学生和班级
	public Testinstance getObj() {
		return obj;
	}
	public void setObj(Testinstance obj) {
		this.obj = obj;
	}
	

}
