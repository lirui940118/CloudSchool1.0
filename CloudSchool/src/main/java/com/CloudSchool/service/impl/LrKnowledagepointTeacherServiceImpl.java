package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.LrKnowledagepointTeacherMapper;
import com.CloudSchool.domain.LrKnowledagepointTeacher;
import com.CloudSchool.domain.statistics.KnowledgePointUpVO;
import com.CloudSchool.service.ClazzcourseteacherService;
import com.CloudSchool.service.LrKnowledagepointTeacherService;
@Service
public class LrKnowledagepointTeacherServiceImpl implements LrKnowledagepointTeacherService{

	@Autowired
	LrKnowledagepointTeacherMapper lrKnowledagepointTeacherMapper;
	@Autowired
	ClazzcourseteacherService clazzcourseteacherService;
	
	@Override
	public Integer submitBadKnowledage(Integer courseId, Integer sId,Integer KnowledagepointId) {
		//找到上报的教员id
		Integer staffId = clazzcourseteacherService.querystaffIdBysIdAndCourseId(courseId, sId);
		//新增上报
		LrKnowledagepointTeacher l = new LrKnowledagepointTeacher();
		l.setStaffid(staffId);//员工id
		l.setSid(sId);//学员id
		l.setKid(KnowledagepointId);//知识点id
		return lrKnowledagepointTeacherMapper.insert(l);
	}

	@Override
	public List<KnowledgePointUpVO> queryAllKnowledagepointByStaffId(Integer staffId) {
		return lrKnowledagepointTeacherMapper.queryAllKnowledagepointByStaffId(staffId);
	}

}
