package com.CloudSchool.domain;

import java.util.Date;

public class GkFangTan {
	private String peoplename;	//访谈人名称
	private String objectname;	//访谈对象名称
	private Date starttime;		//开始时间
	private Date endtime;		//结束时间
	private Integer currentPage;//当前页
	private Integer pageSize;	//每页显示行数
	public String getPeoplename() {
		return peoplename;
	}
	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}
	public String getObjectname() {
		return objectname;
	}
	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public GkFangTan(String peoplename, String objectname, Date starttime, Date endtime, Integer currentPage,
			Integer pageSize) {
		super();
		this.peoplename = peoplename;
		this.objectname = objectname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public GkFangTan() {
		// TODO Auto-generated constructor stub
	}

	
	
	
}
