package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkWjcs;

public interface GkWjcsService {
	//新增问卷测试记录（选择题）
	int insertWjcs(List<CqjUser> quanbulist,Integer wjId);
}
