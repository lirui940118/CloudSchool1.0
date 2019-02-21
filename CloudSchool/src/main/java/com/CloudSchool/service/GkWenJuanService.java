package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.GkPageBean;
import com.CloudSchool.domain.GkQuestionnaire;

public interface GkWenJuanService {
	//查询问卷发布记录
	GkPageBean<GkQuestionnaire> queryAllWenJuanFaBuJiLu(GkQuestionnaire wj);
}
