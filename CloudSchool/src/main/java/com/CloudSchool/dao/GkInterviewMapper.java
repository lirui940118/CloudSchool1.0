package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjParents;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;

public interface GkInterviewMapper {
	
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
	
	//查询所有访谈记录
	List<GkInterview> queryAllFangTan(GkInterview ft);
	//查询所有访谈记录行数
	int queryAllFangTanCount(GkInterview ft);
	//通过访谈id查询访谈详情
	GkInterview queryFangTanDetailsByftid(Integer ftId);
	//通过访谈id删除访谈
	int deleteFangTanByftId(int[] shuzu);
	//新增访谈
	int insertFangTan(GkInterview ft,List<GkInterview> list);
	//查询所有学生（按姓名模糊查）
	List<GkInterview> queryAllXueSheng(@Param(value="name")String name);
	//查询所有员工（按姓名模糊查）
	List<GkInterview> queryAllYuanGong(@Param(value="name")String name);
	//查询所有家长（按姓名模糊查）
	List<GkInterview> queryAllJiaZhang(@Param(value="name")String name);
	
    int deleteByPrimaryKey(Integer ftId);

    int insert(GkInterview record);

    int insertSelective(GkInterview record);

    GkInterview selectByPrimaryKey(Integer ftId);

    int updateByPrimaryKeySelective(GkInterview record);

    int updateByPrimaryKey(GkInterview record);
}