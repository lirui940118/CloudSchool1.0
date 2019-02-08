package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.GkKaoqinState;

public interface GkKaoqinStateService {
	//查詢學員考情情況（write by lirui 考情匯總) 按情況分類顯示總數
	public List<GkKaoqinState> queryKqTotalInfoBySidAndGid(Integer sId,Integer gId);
	//查询员工考勤情况 （write by lirui）按情況分類顯示總數
	public List<GkKaoqinState> queryKqTotalInfoByStaffId(Integer staffId);
	
}
