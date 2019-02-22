package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.Studentupgrade;

public interface StudentupgradeMapper {
    int insert(Studentupgrade record);

    int insertSelective(Studentupgrade record);
    
    int addStudentUpGrades(List<Studentupgrade> Studentupgrade);
    
    int updateStudentUpGrade(List<CqjStudent> Studentupgrade);
}