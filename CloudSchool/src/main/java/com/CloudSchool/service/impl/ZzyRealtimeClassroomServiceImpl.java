package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzyRealtimeClassroomMapper;
import com.CloudSchool.service.ZzyRealtimeClassroomService;
@Service
@Transactional
public class ZzyRealtimeClassroomServiceImpl implements ZzyRealtimeClassroomService{

	@Autowired
	ZzyRealtimeClassroomMapper zzyRealtimeClassroomMapper;
	
	@Override
	public Integer queryRealtimeBysIdAndgId(Integer sId, Integer gId) {
		int score = zzyRealtimeClassroomMapper.queryRealtimeBysIdAndgId(sId, gId);
		if(score>100)
			score = 100;
		else if(score<0)
			score = 0;
		return score;
	}

}
