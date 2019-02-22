package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjParents;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;

public interface GkFangTanService {
	//完善未完成的访谈
	int updateFangTanWS(Integer ftId,String ftObjectExplain);
	
	
	//查询未完成的访谈,别人发起
	List<GkInterview> queryFangTanByWWCB(Integer ftObject);
	//查询未完成的访谈,我发起
	List<GkInterview> queryFangTanByWWCW(Integer ftPeople);
	//查询已完成的访谈,我发起
	List<GkInterview> queryFangTanByYWCW(Integer ftPeople);
	//查询已完成的访谈,别人发起
	List<GkInterview> queryFangTanByYWCB(Integer ftObject);
		
		
	//查询所有访谈
	GkPageBean<GkInterview> queryAllFangTan(GkInterview ft);
	//同过访谈id查询访谈详情
	GkInterview queryFangTanDetailsByftid(Integer ftid);
	//通过访谈id删除访谈
	int deleteFangTanByftId(int[] shuzu);
	//新增访谈
	int insertFangTan(GkInterview ft);
	//查询所有学生（按姓名模糊查）
	List<GkInterview> queryAllXueSheng(String name);
	//查询所有员工（按姓名模糊查）
	List<GkInterview> queryAllYuanGong(String name);
	//查询所有家长（按姓名模糊查）
	List<GkInterview> queryAllJiaZhang(String name);
}
