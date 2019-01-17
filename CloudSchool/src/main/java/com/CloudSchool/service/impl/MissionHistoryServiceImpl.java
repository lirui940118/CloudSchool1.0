package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.MissionhistoryMapper;
import com.CloudSchool.domain.Missionhistory;
import com.CloudSchool.service.MissionHistoryService;

@Service
public class MissionHistoryServiceImpl implements MissionHistoryService{

	@Autowired
	MissionhistoryMapper miss;
	
	@Override
	public List<Missionhistory> query(Integer id) {
		return miss.query(id);
	}

}
