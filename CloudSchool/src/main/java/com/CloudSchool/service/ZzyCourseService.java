package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.statistics.CourseVO;

public interface ZzyCourseService {
	int insert(ZzyCourse record);
	
	//开办选老师
	public List<CourseVO>  queryStaffsAboutOpenClass(Integer gId, Integer mId);

	 public ZzyCourse queryBycid(Integer cid);
	 
	 public List<ZzyCourse> queryBygid(Integer cid);
	 
	 //查询所有课程(赵举峰)
	 List<ZzyCourse> queryCourseAll();


	 public List<ZzyCourse> ZzyqueryCourseAll();
}
