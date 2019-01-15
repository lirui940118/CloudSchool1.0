package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;

public interface GkKaoqinMapper {
	//查询所有员工考勤
	List<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq);
	//查询所有员工考勤行数
	int queryAllKaoQinYuanGongCount(GkKaoqin kq);
	//查询所有职位
	CqjPosition queryAllZhiWei();
				
	
    int deleteByPrimaryKey(Integer kqId);

    int insert(GkKaoqin record);

    int insertSelective(GkKaoqin record);

    GkKaoqin selectByPrimaryKey(Integer kqId);

    int updateByPrimaryKeySelective(GkKaoqin record);

    int updateByPrimaryKey(GkKaoqin record);
}