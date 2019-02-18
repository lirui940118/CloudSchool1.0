package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ParticipationworkclassMapper;
import com.CloudSchool.dao.ParticipationworkstuMapper;
import com.CloudSchool.domain.Participationworkclass;
import com.CloudSchool.domain.Participationworkstu;
import com.CloudSchool.service.ParticipationworkclassService;
@Service
@Transactional
public class ParticipationworkclassServiceImpl implements ParticipationworkclassService{
	
	@Autowired
	ParticipationworkstuMapper participationworkstuMapper;
	
	@Autowired
	ParticipationworkclassMapper ParticipationworkclassMapper;
	//修改作业状态(修改作业状态为已发布)
	@Override
	public int updateStatusById(Participationworkclass obj) {
		Participationworkstu object=new Participationworkstu();
		object.setIscorrect(3);
		obj.setUser5(obj.getId().toString());
		int i=participationworkstuMapper.queryNotCorrectCountByUser1(object);
		if(i<=0) {
			obj.setWstatus(3);
			return ParticipationworkclassMapper.updateStatusById(obj);
		}
		return i;
	}

}
