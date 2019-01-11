package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.Classroom;

public interface ClassroomService {
	public List<Classroom> query();
	public int insert(Classroom cls);
	public int delete(Integer id);
	public Classroom selectByid(Integer id);
	public int update(Classroom cls);
	int insertSelective(Classroom record);
}
