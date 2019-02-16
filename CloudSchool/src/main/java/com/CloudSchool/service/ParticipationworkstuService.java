package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.domain.zjfvo.StuWorkInfo;
import com.CloudSchool.domain.zjfvo.WorkinstanceInfo;

public interface ParticipationworkstuService {
	List<WorkinstanceInfo> queryByCidAndWidShowInfo(Integer cid,Integer wid);
	
	PageBean queryStuWorkInfo(Integer wid,Integer sid,Integer cur,Integer pagesize);
	
	public int updateIscorrectByid(Wtrecord obj);
	
}
