package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.dao.GkInterviewMapper;
import com.CloudSchool.domain.CqjParents;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.service.GkFangTanService;


@Service
public class GkFangTanServiceImpl implements GkFangTanService{
	@Autowired
	GkInterviewMapper gkInterviewMapper;
	@Autowired
	CqjUserMapper cqjUserMapper;
	//查询所有访谈
	public GkPageBean<GkInterview> queryAllFangTan(GkInterview ft) {
		GkInterview ft2 = new GkInterview();
		ft2.setCurrentPage((ft.getCurrentPage()-1)*ft.getPageSize());//下标
		ft2.setObjectname(ft.getObjectname());
		ft2.setPageSize(ft.getPageSize());
		ft2.setPeoplename(ft.getPeoplename());
		ft2.setStartStr(ft.getStartStr());
		ft2.setEndStr(ft.getEndStr());
		List<GkInterview> list = gkInterviewMapper.queryAllFangTan(ft);
		int totalSize = (int)gkInterviewMapper.queryAllFangTanCount(ft2);
		GkPageBean<GkInterview> page = new GkPageBean<GkInterview>(ft.getCurrentPage(), ft.getPageSize(), totalSize, list);
		return page;
	}
	@Override
	public GkInterview queryFangTanDetailsByftid(Integer ftid) {
		// TODO Auto-generated method stub
		
		return gkInterviewMapper.queryFangTanDetailsByftid(ftid);
	}
	@Override
	public int deleteFangTanByftId(int[] shuzu) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.deleteFangTanByftId(shuzu);
	}
	@Override
	public int insertFangTan(GkInterview ft) {
		// TODO Auto-generated method stub
		List<GkInterview> list = ft.getList();
		for(int i = 0 ; i < list.size() ; i++) {
			list.get(i).setCid(cqjUserMapper.queryCidByUserid(list.get(i).getUserid()));
		}
		return gkInterviewMapper.insertFangTan(ft,list);
	}
	@Override
	public List<GkInterview> queryAllXueSheng(String name) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.queryAllXueSheng(name);
	}
	@Override
	public List<GkInterview> queryAllYuanGong(String name) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.queryAllYuanGong(name);
	}
	@Override
	public List<GkInterview> queryAllJiaZhang(String name) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.queryAllJiaZhang(name);
	}
	@Override
	public List<GkInterview> queryFangTanByWWCB(Integer ftObject) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.queryFangTanByWWCB(ftObject);
	}
	@Override
	public int updateFangTanWS(Integer ftId, String ftObjectExplain) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.updateFangTanWS(ftId, ftObjectExplain);
	}
	@Override
	public List<GkInterview> queryFangTanByWWCW(Integer ftPeople) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.queryFangTanByWWCW(ftPeople);
	}
	@Override
	public List<GkInterview> queryFangTanByYWCW(Integer ftPeople) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.queryFangTanByYWCW(ftPeople);
	}
	@Override
	public List<GkInterview> queryFangTanByYWCB(Integer ftObject) {
		// TODO Auto-generated method stub
		return gkInterviewMapper.queryFangTanByYWCB(ftObject);
	}
}
