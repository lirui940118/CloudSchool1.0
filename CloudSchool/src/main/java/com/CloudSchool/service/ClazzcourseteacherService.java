package com.CloudSchool.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Clazzcourseteacher;

public interface ClazzcourseteacherService {
	/**
	 * 查询教员管理的班级
	 * @param tid
	 * @return
	 */
	List<Clazzcourseteacher> queryByTidResultClass(Integer tid);
	//write by lirui 查询该学员该课程的最后一次教学教员id
	public Integer querystaffIdBysIdAndCourseId(Integer courseId,Integer sId);
	
	public List<Clazzcourseteacher> queryzzdx(Integer cid,Date time);
}
