package com.CloudSchool.service;

import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;

public interface GkKaoQinService {
	//查询所有员工考勤信息
	GkPageBean<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq);
}
