package com.CloudSchool.service;

import java.util.ArrayList;
import java.util.List;

import com.CloudSchool.domain.statistics.StudentInfoVO;

public interface ClazzSService {
	//查询多个学生（一个班级），多次考试成绩
    public List<StudentInfoVO> queryStudentTestVoBySidsAndTid(Integer clazzId,Integer staffId,Integer sortType);
    //查询全年级人数信息
    public ArrayList<Integer> queryBaseInfoAboutALlCount();
}
