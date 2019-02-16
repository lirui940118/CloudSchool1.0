package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ParticipationworkstuMapper;
import com.CloudSchool.domain.zjfvo.WorkinstanceInfo;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.domain.zjfvo.StuWorkInfo;
import com.CloudSchool.service.ParticipationworkstuService;
import com.alibaba.fastjson.JSON;
@Service
public class ParticipationworkstuServiceImpl implements ParticipationworkstuService{
	
	@Autowired
	ParticipationworkstuMapper participationworkstuMapper;
	@Override
	public List<WorkinstanceInfo> queryByCidAndWidShowInfo(Integer cid, Integer wid) {
		// TODO Auto-generated method stub
		return participationworkstuMapper.queryByCidAndWidShowInfo(cid, wid);
	}
	@Override
	public PageBean queryStuWorkInfo(Integer wid,Integer sid,Integer cur,Integer pagesize){
		Integer datas=participationworkstuMapper.queryStuWorkInfoCount(wid, sid);
		StuWorkInfo obj=participationworkstuMapper.queryStuWorkInfo(wid,sid,(cur-1)*pagesize,pagesize);
		List<StuWorkInfo> list=new ArrayList<StuWorkInfo>();
		list.add(obj);
		PageBean page=new PageBean(datas, pagesize, list, cur);
		return page;
	}
	
	
	//修改学生作业状态为已批该
	@Override
	public int updateIscorrectByid(Wtrecord obj) {
		// TODO Auto-generated method stub
		return participationworkstuMapper.updateIscorrectByid(3, obj.getWid(), obj.getSid());
	}

}
