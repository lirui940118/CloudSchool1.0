package com.CloudSchool.domain;

import java.util.List;

/**
 * ��ҳ��
 * 
 * @author admin
 *
 */
public class GkPageBean<E> {
	private int currentPage = 1;// 当前页
	private int pageSize = 10;// 每页显示条数
	private int totalSize;// 总条数
	private List<E> list;// 集合

	private int nextPage;// 下一页
	private int prevPage;// 上一页
	private int totalPage;// 总页数


	public GkPageBean(int currentPage, int pageSize, int totalSize, List<E> list) {

		this.totalSize = totalSize;
		this.list = list;

		if (totalSize % pageSize == 0) {
			totalPage = totalSize / pageSize;
		} else {
			totalPage = totalSize / pageSize + 1;
		}
		if (currentPage >= totalPage) {
			nextPage = totalPage;

		} else {
			nextPage = currentPage + 1;
		}
		if (currentPage <= 1) {
			prevPage = 1;
		} else {
			prevPage = currentPage - 1;
		}

		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

}
