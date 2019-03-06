package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkWjcsjf;

public interface GkWjcsjfMapper {
	//互换oid，zid位置
	int updateByoidAndzid(GkWjcsjf jf);
	//通过zid带出所有记录
	List<GkWjcsjf> queryAllByzid(Integer zid);
	//完善后修改状态
	int updateWjcsjf(Integer wjcsjfId);
	//新增问卷测试表计分题(完善问卷时)
	int insertWjcsjfWS(List<GkWjcsjf> list);
	//新增问卷测试表计分题
	int insertWjcsjf(@Param("quanbulist")List<CqjUser> quanbulist,@Param("wjId")Integer wjId,@Param("zId")Integer zId);
	
	
    int deleteByPrimaryKey(Integer wjcsjfId);

    int insert(GkWjcsjf record);

    int insertSelective(GkWjcsjf record);

    GkWjcsjf selectByPrimaryKey(Integer wjcsjfId);

    int updateByPrimaryKeySelective(GkWjcsjf record);

    int updateByPrimaryKey(GkWjcsjf record);
    
    /* 能力问卷调查，评分  统计使用*/
    Integer queryAbilitWjBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId,@Param("tId") Integer tId);
    /* 能力问卷调查，评分  统计使用*/
    Integer queryAbilitWjByStaffId(@Param("staffId")Integer staffId,@Param("tId") Integer tId);
}