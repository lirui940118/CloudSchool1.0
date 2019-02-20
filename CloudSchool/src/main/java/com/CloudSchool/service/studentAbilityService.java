package com.CloudSchool.service;

import java.util.List;

/**
 * 学员能力计算业务
 * @author leerui
 *
 */
public interface studentAbilityService {
	//查询学员5能力 理解能力  识记能力 自控力 应用能力 课堂表现
	public List<Integer> queryStudentAbility(Integer sId, Integer gId);
}
