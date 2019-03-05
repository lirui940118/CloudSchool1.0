package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.dao.LrKnowledagepointMapper;
import com.CloudSchool.domain.LrKnowledagepoint;

public interface LrKnowledagepointService {
	List<LrKnowledagepoint>  queryBySid(Integer sid);
	
	int insertObj(LrKnowledagepoint obj);
}
