package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.MessageMapper;
import com.CloudSchool.domain.Message;
import com.CloudSchool.service.MessageService;
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageMapper mm;
	@Override
	public int insert(Message m) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
