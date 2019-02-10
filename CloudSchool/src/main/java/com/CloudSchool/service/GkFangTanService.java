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
	//查询未完成的访谈
	List<GkInterview> queryFangTanByWWC(Integer ftObject);
	//查询所有访谈
	GkPageBean<GkInterview> queryAllFangTan(GkInterview ft);
	//同过访谈id查询访谈详情
	GkInterview queryFangTanDetailsByftid(Integer ftid);
	//通过访谈id删除访谈
	int deleteFangTanByftId(int[] shuzu);
	//新增访谈
	int insertFangTan(GkInterview ft,Integer[] shuzu);
	//查询所有学生（按姓名模糊查）
	List<GkInterview> queryAllXueSheng(String name);
	//查询所有员工（按姓名模糊查）
	List<GkInterview> queryAllYuanGong(String name);
	//查询所有家长（按姓名模糊查）
	List<GkInterview> queryAllJiaZhang(String name);
}
