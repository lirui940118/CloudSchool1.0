package com.CloudSchool.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GkFangTan {
	private String peoplename;	//访谈人名称
	private String objectname;	//访谈对象名称
	private String startStr;
	private String endStr;
	private Integer currentPage;//当前页
	private Integer pageSize;	//每页显示行数
	private String ftstartStr;
	
	
	
	public String getFtstartStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ftstartStr);
	}
	public void setFtstartStr(String ftstartStr) {
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.ftstartStr = ftstartStr;
	}
	public String getStartStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startStr);
	}
	public void setStartStr(String startStr) {
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.startStr = startStr;
	}
	public String getEndStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endStr);
	}
	public void setEndStr(String endStr) {
		//SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.endStr = endStr;
	}
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
	public GkFangTan(String peoplename, String objectname, Integer currentPage,
			Integer pageSize) {
		super();
		this.peoplename = peoplename;
		this.objectname = objectname;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public GkFangTan() {
		// TODO Auto-generated constructor stub
		this.currentPage=1;
		this.pageSize=1;
	}

	
	
	
}
