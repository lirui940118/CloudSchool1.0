package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzyTeacherAbilityMapper;
import com.CloudSchool.domain.ZzyTeacherAbility;
import com.CloudSchool.service.ZzyTeacherAbilityService;

@Service
@Transactional
public class ZzyTeacherAbilityServiceimpl implements ZzyTeacherAbilityService{
	
	
	@Autowired
	ZzyTeacherAbilityMapper terchermapper;

	@Override
	public List<ZzyTeacherAbility> queryBytid(Integer tid) {
		// TODO Auto-generated method stub
		return terchermapper.queryBytid(tid);
	}

	@Override
	public Integer insertTea(List<ZzyTeacherAbility> list) {
		// TODO Auto-generated method stub
		terchermapper.deleteAllBytid(list.get(0).getTid());
		terchermapper.updateStaffBytid(list.get(0).getTid());
		return terchermapper.insertTea(list);
	}



}
