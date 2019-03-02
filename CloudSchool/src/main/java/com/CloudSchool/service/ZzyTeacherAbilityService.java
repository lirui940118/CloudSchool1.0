package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyTeacherAbility;

public interface ZzyTeacherAbilityService {
	public List<ZzyTeacherAbility>  queryBytid(Integer tid);
	 public Integer insertTea(List<ZzyTeacherAbility> list);
	    

}
