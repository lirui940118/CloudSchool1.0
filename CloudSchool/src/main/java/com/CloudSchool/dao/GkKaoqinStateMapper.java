package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.GkKaoqinState;

public interface GkKaoqinStateMapper {
	
	//write by lirui
	//查詢學員考情情況（write by lirui 考情匯總) 按情況分類顯示總數
	public List<GkKaoqinState> queryKqTotalInfoBySidAndGid(Integer sId,Integer gId);
	//查询员工考勤情况 （write by lirui）按情況分類顯示總數
	public List<GkKaoqinState> queryKqTotalInfoByStaffId(Integer staffId);
	
    int deleteByPrimaryKey(Integer kqStateId);

    int insert(GkKaoqinState record);

    int insertSelective(GkKaoqinState record);

    GkKaoqinState selectByPrimaryKey(Integer kqStateId);

    int updateByPrimaryKeySelective(GkKaoqinState record);

    int updateByPrimaryKey(GkKaoqinState record);
}