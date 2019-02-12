package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.MessageMapper;
import com.CloudSchool.dao.MessagereceiverMapper;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Message;
import com.CloudSchool.service.MessageService;
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageMapper mm;
	@Autowired
	MessagereceiverMapper mrm;
	@Override
	/**
	 * 新增消息(title:如系统提示，考试提示，任务提示;content:具体详细内容;sender:系统为0-说的就是你们调用的；url:有就填，time：不填；receiver:int[],接收者*用户id*，必填，数组存储，支持多人)
	 */
	public int insert(Message m) {
		// TODO Auto-generated method stub
		System.out.println("生成消息");
		int jg=mm.insert(m);
		int jg1=mrm.insert(m);
		return jg1;
	}
	@Override
	public List<Message> getChatRecord(int userid,int chatid) {
		// TODO Auto-generated method stub
		return mm.getChatRecord(userid,chatid);
	}
	@Override
	public List<CqjUser> getChatList(Integer userid) {
		// TODO Auto-generated method stub
		return mm.getChatList(userid);
	}
	
}
