package com.CloudSchool.domain.zjfvo;

import java.util.List;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.Testinstance;
import com.CloudSchool.domain.Testmodule;
import com.CloudSchool.domain.TopicWithBLOBs;

public class CorrectTestInfo {
	private Integer id;
	private List<TopicWithBLOBs> list;
	private CqjStudent stu;
	private String teachname;
	private String cname;
	private Integer tcount;
	private Integer getsocre;
	private Integer clazzid;
	private Integer user1;
	private String stuname;
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStunumber() {
		return stunumber;
	}
	public void setStunumber(String stunumber) {
		this.stunumber = stunumber;
	}
	private String stunumber;
	public Integer getUser1() {
		return user1;
	}
	public void setUser1(Integer user1) {
		this.user1 = user1;
	}
	public Integer getClazzid() {
		return clazzid;
	}
	public void setClazzid(Integer clazzid) {
		this.clazzid = clazzid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<TopicWithBLOBs> getList() {
		return list;
	}
	public void setList(List<TopicWithBLOBs> list) {
		this.list = list;
	}
	public CqjStudent getStu() {
		return stu;
	}
	public void setStu(CqjStudent stu) {
		this.stu = stu;
	}
	public String getTeachname() {
		return teachname;
	}
	public void setTeachname(String teachname) {
		this.teachname = teachname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getTcount() {
		return tcount;
	}
	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}
	public Integer getGetsocre() {
		return getsocre;
	}
	public void setGetsocre(Integer getsocre) {
		this.getsocre = getsocre;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
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
	private Integer count;
	private Testinstance  testinstance;
	private Testmodule testmodule;
}
