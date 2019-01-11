package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzyVersionMapper;
import com.CloudSchool.domain.ZzyVersion;
import com.CloudSchool.service.ZzyVersionService;

@Service
@Transactional
public class ZzyVersionServiceimpl implements ZzyVersionService{
	
	@Autowired
	ZzyVersionMapper ma;

	@Override
	public int deleteByPrimaryKey(Integer vid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ZzyVersion record) {
		// TODO Auto-generated method stub
		return 0;
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

}
