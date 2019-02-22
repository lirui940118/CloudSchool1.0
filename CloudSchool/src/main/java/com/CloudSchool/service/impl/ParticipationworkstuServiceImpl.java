package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ParticipationworkstuMapper;
import com.CloudSchool.dao.WorkgradeMapper;
import com.CloudSchool.dao.WorkinstanceMapper;
import com.CloudSchool.dao.WtrecordMapper;
import com.CloudSchool.domain.zjfvo.WorkinstanceInfo;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Workgrade;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.domain.zjfvo.StuWorkInfo;
import com.CloudSchool.domain.zjfvo.StudentWork;
import com.CloudSchool.service.ParticipationworkstuService;
import com.alibaba.fastjson.JSON;
@Service
public class ParticipationworkstuServiceImpl implements ParticipationworkstuService{
	
	@Autowired
	ParticipationworkstuMapper participationworkstuMapper;
	
	@Autowired
	WtrecordMapper wtrecordMapper;
	@Autowired
	WorkinstanceMapper workinstanceMapper;
	@Autowired
	WorkgradeMapper workgradeMapper;
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
		int i=participationworkstuMapper.updateIscorrectByid(3, obj.getWid(), obj.getSid());
		if(i>0) {
			//作业总成绩
			int score=wtrecordMapper.queryByWidAndSidSumScore(obj.getWid(), obj.getSid());
			Workgrade object=new Workgrade();
			object.setWid(obj.getWid());
			object.setUid(obj.getSid());
			object.setScore(score);
			//作业模板总分
			int worksumscore=workinstanceMapper.querySumScoreById(obj.getWid());
			//及格
			if(score>=worksumscore*0.9) {
				object.setRank("A");
			}else if(score>=worksumscore*0.8 && score<worksumscore*0.9) {
				object.setRank("B");
			}else if(score>=worksumscore*0.6 && score<worksumscore*0.8) {
				object.setRank("C");
			}else if(score<worksumscore*0.6) {
				object.setRank("D");
			}
			return workgradeMapper.inserStuScore(object);
		}
		return i;
	}
	@Override
	public PageBean queryStuWorkBySid(Integer sid,Integer cur,Integer pagesize,Integer isCorrect) {
		int datas=participationworkstuMapper.queryStuWorkBySidCount(sid,isCorrect);
		PageBean page=new PageBean(datas, pagesize, participationworkstuMapper.queryStuWorkBySid(sid,(cur-1)*pagesize,pagesize,isCorrect), cur);
		return page;
	}

}
