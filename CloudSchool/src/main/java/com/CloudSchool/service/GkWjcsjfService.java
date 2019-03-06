package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkWjcsjf;

public interface GkWjcsjfService {
	//互换oid，zid位置
	int updateByoidAndzid(GkWjcsjf jf);
	//通过zid带出所有记录
	List<GkWjcsjf> queryAllByzid(Integer zid);
	//完善后修改状态
	int updateWjcsjf(Integer wjcsjfId);
	//新增问卷测试表计分题(完善问卷时)
	int insertWjcsjfWS(List<GkWjcsjf> list);
	//新增问卷测试表计分题
	int insertWjcsjf(List<CqjUser> quanbulist,Integer wjId,Integer zId);

	/* 能力问卷调查，评分  统计使用*/
    Integer queryAbilitWjBysIdAndgId(Integer sId,Integer gId,Integer tId);
    /* 能力问卷调查，评分  统计使用*/
    Integer queryAbilitWjByStaffId(Integer staffId,Integer tId);
}
