package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzyCourseEventsMapper;
import com.CloudSchool.domain.ZzyCourseEvents;
import com.CloudSchool.service.ZzyCourseEventService;

@Service
@Transactional
public class ZzyCourseEventServiceimpl implements ZzyCourseEventService{
	@Autowired
	ZzyCourseEventsMapper z;

	@Override
	public Integer insertEvents(List<ZzyCourseEvents> l) {
		// TODO Auto-generated method stub
		return z.insertEvents(l);
	}
}
