package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.TopicMapper;
import com.CloudSchool.dao.TopictypeMapper;
import com.CloudSchool.domain.Topictype;
import com.CloudSchool.service.TopicTypeService;
@Service
@Transactional
public class TopicTypeServiceImpl implements TopicTypeService{
	
	@Autowired
	TopictypeMapper topictypeMapper;
	@Override
	public List<Topictype> queryTopicTypeAll() {
		// TODO Auto-generated method stub
		return topictypeMapper.queryTopicTypeAll();
	}
	
}
