package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.statistics.StudentInfoVO;

public interface ClazzSMapper {
	//查询多个学生（一个班级），多次考试成绩
    public List<StudentInfoVO> queryStudentTestVoBySidsAndTid(@Param("clazzId")Integer clazzId,@Param("staffId")Integer staffId);
}
