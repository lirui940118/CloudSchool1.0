package com.CloudSchool.domain.statistics;

import java.util.List;

public class GradeVO {
	private Integer gradeId;//年级id
	private String gradeName;//年级名称
	private List<PCVO> pcList;//班级集合
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public List<PCVO> getPcList() {
		return pcList;
	}
	public void setPcList(List<PCVO> pcList) {
		this.pcList = pcList;
	}
	
	
}
