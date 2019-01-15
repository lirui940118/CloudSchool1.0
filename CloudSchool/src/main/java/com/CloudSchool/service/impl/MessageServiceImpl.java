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
	/**
	 * 新增消息(title:如系统提示，考试提示，任务提示;content:具体详细内容;sender:系统为0-说的就是你们调用的；url:有就填，time：不填；receiver:int[],接收者*用户id*，必填，数组存储，支持多人)
	 */
	public int insert(Message m) {
		// TODO Auto-generated method stub
		System.out.println("生成消息");
		return 0;
	}
	
}
