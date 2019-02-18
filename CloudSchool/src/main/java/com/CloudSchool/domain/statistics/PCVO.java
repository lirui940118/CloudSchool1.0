package com.CloudSchool.domain.statistics;

import java.util.List;

/**
 * 批次对象
 * @author leerui
 *
 */
public class PCVO {
	private String clazzPc;//批次名称orId

	List<ClazzBaseInfoVO> clazzList;//该批次下的班级集合
	
	
	public String getClazzPc() {
		return clazzPc;
	}

	public void setClazzPc(String clazzPc) {
		this.clazzPc = clazzPc;
	}

	public List<ClazzBaseInfoVO> getClazzList() {
		return clazzList;
	}

	public void setClazzList(List<ClazzBaseInfoVO> clazzList) {
		this.clazzList = clazzList;
	}
	
}
