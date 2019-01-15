package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.Clazzstudent;

public interface ClassStudentService {
    //根据班级id查询该班级的学生
    public List<Clazzstudent> queryByMo(Integer cid);
}
