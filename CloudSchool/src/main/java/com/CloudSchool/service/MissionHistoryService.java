package com.CloudSchool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CloudSchool.domain.Missionhistory;


public interface MissionHistoryService {
	List<Missionhistory> query(Integer id);
}
