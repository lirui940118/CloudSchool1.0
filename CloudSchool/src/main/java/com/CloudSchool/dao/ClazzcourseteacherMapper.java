package com.CloudSchool.dao;

import java.util.List;

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
}