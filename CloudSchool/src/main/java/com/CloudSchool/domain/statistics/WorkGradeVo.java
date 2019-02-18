package com.CloudSchool.domain.statistics;

/**
 * 统计学员完成作业情况
 * @author leerui
 *
 */
public class WorkGradeVo {
	//等级名称
	private String rankName;
	//次数
	private Integer workCount;
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public Integer getWorkCount() {
		return workCount;
	}
	public void setWorkCount(Integer workCount) {
		this.workCount = workCount;
	}
	
}
