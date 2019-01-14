package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.NoticeMapper;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Notice;
import com.CloudSchool.service.NoticeService;
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper nm;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return nm.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Notice record) {
		// TODO Auto-generated method stub
		return nm.insert(record);
	}

	@Override
	public int insertSelective(Notice record) {
		// TODO Auto-generated method stub
		return nm.insertSelective(record);
	}

	@Override
	public Notice selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return nm.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Notice record) {
		// TODO Auto-generated method stub
		return nm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Notice record) {
		// TODO Auto-generated method stub
		return nm.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Notice record) {
		// TODO Auto-generated method stub
		return nm.updateByPrimaryKey(record);
	}

	@Override
	public List<Notice> query(String time,String str) {
		// TODO Auto-generated method stub
		return nm.query(time,str);
	}

	@Override
	public CqjUser querpersonerInfo(Integer uid) {
		// TODO Auto-generated method stub
		return nm.querpersonerInfo(uid);
	}

	
}
