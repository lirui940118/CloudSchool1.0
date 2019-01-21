package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzcourseteacher;

public interface ClazzcourseteacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazzcourseteacher record);

    int insertSelective(Clazzcourseteacher record);

    Clazzcourseteacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazzcourseteacher record);

    int updateByPrimaryKey(Clazzcourseteacher record);
    //自定义-批量新增-老师
    int insertAll(ClazzInfo record);
    
   /* 根据教员查询管理的班级*/
    List<Clazzcourseteacher> queryByTidResultClass(Integer tid);
    
    //根据班级id查询班级所有教员
    public List<Clazzcourseteacher> queryByclazzid(Integer id);
    //write by lirui 查询该学员该课程的最后一次教学教员id
    public Integer querystaffIdBysIdAndCourseId(@Param("courseId") Integer courseId,@Param("sId") Integer sId);
    
}