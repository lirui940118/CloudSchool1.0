package com.CloudSchool.dao;

import java.util.List;
import java.util.function.DoubleToLongFunction;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Workgrade;
import com.CloudSchool.domain.statistics.WorkGradeVo;

public interface WorkgradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workgrade record);

    int insertSelective(Workgrade record);

    Workgrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workgrade record);

    int updateByPrimaryKey(Workgrade record);
    
    int inserStuScore(Workgrade obj);
    //作业完成情况
    public List<WorkGradeVo> queryStudentWorkInfoBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId);
    //学员作业完成率
    public Double queryStudentWorkTimelyFinishRate(@Param("sId") Integer sId,@Param("gId") Integer gId);
}