package com.CloudSchool.domain;

import java.util.List;

public class PageBean {
	private Integer datas;			//数据总条数
	private Integer pageSize;		//页大小
	private List list;				//每页显示的数据集合
	private Integer nextPage;		//下一页
	private Integer prePage;		//上一页
	private Integer presentPage;	//当前页
	private Integer pageCount;		//总页数
	
	public PageBean() {
		
	}
	public Integer getDatas() {
		return datas;
	}
	public void setDatas(Integer datas) {
		this.datas = datas;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getPresentPage() {
		return presentPage;
	}
	public void setPresentPage(Integer presentPage) {
		this.presentPage = presentPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public PageBean(Integer datas, Integer pageSize, List list,Integer presentPage) {
		super();
		this.datas = datas;
		this.pageSize = pageSize;
		this.list = list;
		this.presentPage = presentPage;	
		this.pageCount = this.datas%this.pageSize==0?this.datas/this.pageSize:this.datas/this.pageSize+1;
		this.nextPage = this.presentPage<this.pageCount?this.presentPage+1:presentPage;
		this.prePage =  this.presentPage>1?this.presentPage-1:presentPage;
	}
}
