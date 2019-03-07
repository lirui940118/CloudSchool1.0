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
	ZzyRealtimeClassroomMapper zzyRealtimeClassroomMapper;
	
	@Override
	public List<ZzyEventType> queryByuid(Integer uid) {
		// TODO Auto-generated method stub
		return zzyRealtimeClassroomMapper.queryByuid(uid);
	}

	@Override
	public Integer queryByHuida(Integer tid, Integer sid, Integer cid) {
		// TODO Auto-generated method stub
		return zzyRealtimeClassroomMapper.queryByHuida(tid, sid, cid);
	}

	@Override
	public Integer queryByHuidaTure(Integer tid, Integer sid, Integer cid) {
		// TODO Auto-generated method stub
		return zzyRealtimeClassroomMapper.queryByHuidaTure(tid, sid, cid);
	}

	@Override
	public Integer insertZidingyi(ZzyEventType ss) {
		// TODO Auto-generated method stub
		return zzyRealtimeClassroomMapper.insertZidingyi(ss);
	}

	@Override
	public Integer insertTSEid(ZzyRealtimeClassroom sss) {
		// TODO Auto-generated method stub
		return zzyRealtimeClassroomMapper.insertTSEid(sss);
	}

	@Override
	public Integer queryRealtimeBysIdAndgId(Integer sId, Integer gId) {
		Integer score = zzyRealtimeClassroomMapper.queryRealtimeBysIdAndgId(sId, gId);
		if(score == null)
			return 0;
		else if(score<0)
			return 0;
		else if(score>100)
			return 100;
		else 
			return score;//错误
	}

}
