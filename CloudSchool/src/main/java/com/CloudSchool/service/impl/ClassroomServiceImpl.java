package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ClassroomMapper;
import com.CloudSchool.dao.ZzyClassScheduleMapper;
import com.CloudSchool.domain.Classroom;
import com.CloudSchool.service.ClassroomService;
import com.alibaba.fastjson.JSON;
@Service
public class ClassroomServiceImpl implements ClassroomService{
	@Autowired
	ClassroomMapper clr;
	@Autowired
	ZzyClassScheduleMapper zzyClassScheduleMapper;
	public List<Classroom> query(){
		return clr.query();
	}

	@Override
	public int insert(Classroom cls) {
		return clr.insertSelective(cls);
	}

	@Override
	public int delete(Integer id) {
		return clr.deleteByPrimaryKey(id);
	}

	@Override
	public Classroom selectByid(Integer id) {
		return clr.selectByPrimaryKey(id);
	}

	@Override
	public int update(Classroom cls) {
		return clr.updateByPrimaryKeySelective(cls);
	}

	@Override
	public int insertSelective(Classroom record) {
		return clr.insertSelective(record);
	}
	
	//查询到所有这个时间段空教室
	@Override
	public List<Classroom> queryClassRoomAll(String startTime, String endTime) {
		List<Classroom> list=clr.query();
		/*for (Classroom classroom : list) {
			zzyClassScheduleMapper
		}*/
		return null;
	}

}
