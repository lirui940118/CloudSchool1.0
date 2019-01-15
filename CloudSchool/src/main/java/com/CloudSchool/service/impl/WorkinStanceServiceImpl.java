package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ParticipationworkclassMapper;
import com.CloudSchool.dao.WorkinstanceMapper;
import com.CloudSchool.domain.zjfvo.WorkPublishParam;
import com.CloudSchool.service.WorkinStanceService;
@Service
@Transactional
public class WorkinStanceServiceImpl implements WorkinStanceService{
	@Autowired
	WorkinstanceMapper workinstanceMapper;
	
	@Autowired
	ParticipationworkclassMapper participationworkclassMapper;
	@Override
	public int publishWork(WorkPublishParam obj) {
		int i=workinstanceMapper.insertSelective(obj.getObj());	//添加作业实例
		if(i>0) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("wid", obj.getObj().getId());
			map.put("list", obj.getCid());
			/*participationworkclassMapper.insertObjList(map);*/	//添加参加考试的班级
		}
		return 0;
	}

}
