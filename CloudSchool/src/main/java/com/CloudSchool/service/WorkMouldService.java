package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Workmould;
import com.CloudSchool.domain.zjfvo.TeacherAdminStu;

public interface WorkMouldService {
	  PageBean queryByTidMould(Integer tid,Integer cur,Integer pagesize);
	
	  List<TeacherAdminStu> queryByTidAdminStuAll(Integer tid);
	  
}
