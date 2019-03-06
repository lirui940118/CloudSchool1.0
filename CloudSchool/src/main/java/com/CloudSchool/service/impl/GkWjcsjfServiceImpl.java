package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.GkWjcsjfMapper;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkWjcsjf;
import com.CloudSchool.service.GkWjcsjfService;
@Service
@Transactional
public class GkWjcsjfServiceImpl implements GkWjcsjfService{

	@Autowired
	GkWjcsjfMapper gkWjcsjfMapper;
	
	
	@Override
	public Integer queryAbilitWjBysIdAndgId(Integer sId, Integer gId,Integer tId) {
		return gkWjcsjfMapper.queryAbilitWjBysIdAndgId(sId, gId,tId);
	}


	@Override
	public Integer queryAbilitWjByStaffId(Integer staffId,Integer tId) {
		return gkWjcsjfMapper.queryAbilitWjByStaffId(staffId,tId);
	}


	@Override
	public int insertWjcsjf(List<CqjUser> quanbulist, Integer wjId, Integer zId) {
		// TODO Auto-generated method stub
		return gkWjcsjfMapper.insertWjcsjf(quanbulist, wjId, zId);
	}


	@Override
	public int insertWjcsjfWS(List<GkWjcsjf> list) {
		// TODO Auto-generated method stub
		return gkWjcsjfMapper.insertWjcsjfWS(list);
	}


	@Override
	public int updateWjcsjf(Integer wjcsjfId) {
		// TODO Auto-generated method stub
		return gkWjcsjfMapper.updateWjcsjf(wjcsjfId);
	}


	@Override
	public List<GkWjcsjf> queryAllByzid(Integer zid) {
		// TODO Auto-generated method stub
		return gkWjcsjfMapper.queryAllByzid(zid);
	}


	@Override
	public int updateByoidAndzid(GkWjcsjf jf) {
		// TODO Auto-generated method stub
		return gkWjcsjfMapper.updateByoidAndzid(jf);
	}



}
