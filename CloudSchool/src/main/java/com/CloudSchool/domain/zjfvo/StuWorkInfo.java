package com.CloudSchool.domain.zjfvo;

import java.util.List;

import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Workinfo;

public class StuWorkInfo {
	private Integer id;
	//题目
	private List<TopicWithBLOBs> list;
	//学生
	private CqjStudent cqjstudentobj;
	//班级
	private Clazz clazzobj;
	//已得分
	private Integer score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIsmodification() {
		return ismodification;
	}
	public void setIsmodification(Integer ismodification) {
		this.ismodification = ismodification;
	}
	//题目总数量
	private Integer tcount;
	//已修改题目数量
	private Integer ismodification;
	
	public List<TopicWithBLOBs> getList() {
		return list;
	}
	public void setList(List<TopicWithBLOBs> list) {
		this.list = list;
	}
	public CqjStudent getCqjstudentobj() {
		return cqjstudentobj;
	}
	public void setCqjstudentobj(CqjStudent cqjstudentobj) {
		this.cqjstudentobj = cqjstudentobj;
	}
	public Clazz getClazzobj() {
		return clazzobj;
	}
	public void setClazzobj(Clazz clazzobj) {
		this.clazzobj = clazzobj;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getTcount() {
		return tcount;
	}
	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}
}
