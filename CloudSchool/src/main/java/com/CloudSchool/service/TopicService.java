package com.CloudSchool.service;

import com.CloudSchool.domain.TopicWithBLOBs;

public interface TopicService {
	int insertSelective(TopicWithBLOBs record);
}
