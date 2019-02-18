package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.statistics.CourseVO;

public interface ZzyCourseMapper {
    int insert(ZzyCourse record);

    int insertSelective(ZzyCourse record);
    
    public List<ZzyCourse> queryBygid(Integer gid);
    
    public ZzyCourse queryBycid(Integer cid);
    
    //开办选老师
  	public List<CourseVO>  queryStaffsAboutOpenClass(@Param("gId") Integer gId,@Param("mId") Integer mId);
}