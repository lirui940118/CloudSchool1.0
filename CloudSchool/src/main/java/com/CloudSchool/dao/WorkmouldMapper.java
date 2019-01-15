package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Workmould;
import com.CloudSchool.domain.zjfvo.TeacherAdminStu;

public interface WorkmouldMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workmould record);

    int insertSelective(Workmould record);

    Workmould selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workmould record);

    int updateByPrimaryKey(Workmould record);
    
    Integer[] queryWorkMouldType(Workmould obj);
    
    List<Workmould> queryByTidMould(@Param("tid")Integer tid,@Param("cur")Integer cur,@Param("pagesize")Integer pagesize);
    
    int queryByTidMouldCount(Integer tid);
    
   //根据老师查询到管理的班级所有的学生
    List<TeacherAdminStu> queryByTidAdminStuAll(Integer tid);
    
    int updateCountByid(Integer id);
}