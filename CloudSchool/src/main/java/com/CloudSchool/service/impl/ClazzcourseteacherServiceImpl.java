package com.CloudSchool.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzcourseteacherMapper;
import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.service.ClazzcourseteacherService;
@Service
@Transactional
public class ClazzcourseteacherServiceImpl implements ClazzcourseteacherService{
	@Autowired
	ClazzcourseteacherMapper clazzcourseteacherMapper;

	@Override
	public List<Clazzcourseteacher> queryByTidResultClass(Integer tid) {
		// TODO Auto-generated method stub
		return clazzcourseteacherMapper.queryByTidResultClass(tid);
	}

	@Override
	public Integer querystaffIdBysIdAndCourseId(Integer courseId, Integer sId) {
		return clazzcourseteacherMapper.querystaffIdBysIdAndCourseId(courseId, sId);
	}

	@Override
	public List<Clazzcourseteacher> queryzzdx(Integer cid, Date time) {
		// TODO Auto-generated method stub
		return clazzcourseteacherMapper.queryzzdx(cid, time);
	}
}
