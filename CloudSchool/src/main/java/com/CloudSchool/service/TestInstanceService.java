package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyGrade;

public interface TestInstanceService {
	
	public List<ZzyGrade> queryGrade(String id);
}
