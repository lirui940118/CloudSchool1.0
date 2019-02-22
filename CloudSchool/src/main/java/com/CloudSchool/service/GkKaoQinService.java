package com.CloudSchool.service;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;

public interface GkKaoQinService {
	//查询所有员工考勤信息
	GkPageBean<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq);
	
	/*学员考勤到勤率*/
    Double querykaoqinRateBygIdAndsId(Integer sId,Integer gId);
    /*员工考勤道勤率*/
    Double querykaoqinRateByStaffId(Integer staffId);
}
