package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.NoticeMapper;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Notice;
import com.CloudSchool.handler.MyWebSocketHandler;
import com.CloudSchool.service.NoticeService;
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper nm;
	@Autowired
	MyWebSocketHandler handler;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return nm.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Notice record) {
		// TODO Auto-generated method stub
		sendnoticeTips(record);
//		return nm.insert(record);
		return 1;
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
	
	/**
	 * 新增通知触发消息提醒
	 */
	public String sendnoticeTips(Notice n) {
		String status=null;
		//发送提醒给用户
		System.out.println("系统消息提醒用户：");
		int[] receiverlist= null;
		List<Integer> list=new ArrayList<Integer>();
		if(n.getReceiverrange()==5) {
			//班级对应的学生
			receiverlist=nm.getNoticeReceiveByGradeidOrClazzid(null, n.getReceiverid());
		}else if(n.getReceiverrange()==4) {
			//年级对应的学生
			receiverlist=nm.getNoticeReceiveByGradeidOrClazzid(n.getReceiverid(), null);
		}else{
			receiverlist=nm.getNoticeReceiveByRange(n.getReceiverrange());
		}
		for (int receiver : receiverlist) {
			System.out.println(receiver+",");
			status = handler.sendMsg(receiver+"", "notice-<div class=\"m_message_left\">"+n.getContent()+"</div>");
		}
		return status;
	}
}
