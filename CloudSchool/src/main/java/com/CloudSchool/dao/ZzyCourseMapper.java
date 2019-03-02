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
    


    //根据年级id 专业id查询课程
    public List<ZzyCourse> queryBygidAndmid(@Param("gid")Integer gid,@Param("mid")Integer mid);
    
    //根据年级id查询不分专业的年级的所有课程
    public List<ZzyCourse> queryBygidTwo(Integer gid);
    
    //查询所有课程
    public List<ZzyCourse> ZzyqueryCourseAll();
    

}