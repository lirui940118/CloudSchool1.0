package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.TopicMapper;
import com.CloudSchool.dao.TopicoptionMapper;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Topicoption;
import com.CloudSchool.service.TopicService;
@Service
@Transactional
public class TopicServiceImpl implements TopicService{
	@Autowired
	TopicMapper topicMapper;
	@Autowired
	TopicoptionMapper topicoptionMapper;
	@Override
	//添加题目
	public int insertSelective(TopicWithBLOBs record) {
		//添加题目
		int i=topicMapper.insertSelective(record);
		//添加选择题选项
		if(i>0 && record.getTopicType().getId()==1) {
			List<Topicoption> list=record.getList();	//所有题目
			Map<String, Object> obj=new HashMap<String, Object>();
			obj.put("tid", record.getId());
			obj.put("list", list);
			topicoptionMapper.insertList(obj);
		}
		return 0;
	}
	
}
