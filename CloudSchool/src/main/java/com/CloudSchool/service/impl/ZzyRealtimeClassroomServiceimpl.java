 package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzyRealtimeClassroomMapper;
import com.CloudSchool.domain.ZzyEventType;
import com.CloudSchool.domain.ZzyRealtimeClassroom;
import com.CloudSchool.service.ZzyRealtimeClassroomService;

@Service
@Transactional
public class ZzyRealtimeClassroomServiceimpl implements ZzyRealtimeClassroomService{

	@Autowired
	ZzyRealtimeClassroomMapper realtime;
	
	@Override
	public List<ZzyEventType> queryByuid(Integer uid) {
		// TODO Auto-generated method stub
		return realtime.queryByuid(uid);
	}

	@Override
	public Integer queryByHuida(Integer tid, Integer sid, Integer cid) {
		// TODO Auto-generated method stub
		return realtime.queryByHuida(tid, sid, cid);
	}

	@Override
	public Integer queryByHuidaTure(Integer tid, Integer sid, Integer cid) {
		// TODO Auto-generated method stub
		return realtime.queryByHuidaTure(tid, sid, cid);
	}

	@Override
	public Integer insertZidingyi(ZzyEventType ss) {
		// TODO Auto-generated method stub
		return realtime.insertZidingyi(ss);
	}

	@Override
	public Integer insertTSEid(ZzyRealtimeClassroom sss) {
		// TODO Auto-generated method stub
		return realtime.insertTSEid(sss);
	}

}
