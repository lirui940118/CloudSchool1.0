package com.CloudSchool.domain.statistics;
/**
 * 	同一批次下多个班级的考试综合分数（多项）
 * 	用于年级首页
 * @author leerui
 *
 */
public class TestComprehensiveScoreVO {
	private Integer cId;//年级id
	private String cName;//年级名称
	private Double maxScore;//最高分
	private Double minScore;//最低分
	private Double heightAvgScore;//高平均得
	private Double lowAvgScore;//低平均得
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Double getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(Double maxScore) {
		this.maxScore = maxScore;
	}
	public Double getMinScore() {
		return minScore;
	}
	public void setMinScore(Double minScore) {
		this.minScore = minScore;
	}
	public Double getHeightAvgScore() {
		return heightAvgScore;
	}
	public void setHeightAvgScore(Double heightAvgScore) {
		this.heightAvgScore = heightAvgScore;
	}
	public Double getLowAvgScore() {
		return lowAvgScore;
	}
	public void setLowAvgScore(Double lowAvgScore) {
		this.lowAvgScore = lowAvgScore;
	}
}
