package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.dao.ZzyVersionMapper;
import com.CloudSchool.domain.ZzyVersion;
import com.CloudSchool.service.ZzyVersionService;

@Service
@Transactional
public class ZzyVersionServiceimpl implements ZzyVersionService{
	
	@Autowired
	ZzyVersionMapper ma;
	
	@Autowired
	ZzyGradeMapper grma;

	@Override
	public int deleteByPrimaryKey(Integer vid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ZzyVersion record) {
		// TODO Auto-generated method stub
		//新增版本
		int i=ma.insert(record);
		//创建一个集合
		Map<String,Object> map= new HashMap<String,Object>();
		//第一个值为刚刚新建的版本的id
		map.put("vid", record.getVid());
		//第二个值为年级信息
		map.put("list", record.getList());
		//新增年级方法
		grma.insertMap(map);
		return i;
	}

	@Override
	public int insertSelective(ZzyVersion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ZzyVersion selectByPrimaryKey(Integer vid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ZzyVersion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ZzyVersion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ZzyVersion> queryAll() {
		// TODO Auto-generated method stub
		return ma.queryAll();
	}

	@Override
	public ZzyVersion VerAndGrade(Integer vid) {
		// TODO Auto-generated method stub
		return ma.VerAndGrade(vid);
	}

	@Override
	public ZzyVersion VerAndGrade2(Integer vid) {
		// TODO Auto-generated method stub
		return ma.VerAndGrade2(vid);
	}

}
