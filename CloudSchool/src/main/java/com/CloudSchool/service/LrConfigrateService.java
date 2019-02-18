package com.CloudSchool.service;

import com.CloudSchool.domain.LrConfigrate;

public interface LrConfigrateService {
	public LrConfigrate queryAllConfig();
	
	public Integer updateAllConfig(LrConfigrate record);
}
