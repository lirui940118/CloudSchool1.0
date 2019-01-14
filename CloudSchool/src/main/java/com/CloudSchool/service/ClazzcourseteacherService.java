package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.Clazzcourseteacher;

public interface ClazzcourseteacherService {
	/**
	 * 查询教员管理的班级
	 * @param tid
	 * @return
	 */
	List<Clazzcourseteacher> queryByTidResultClass(Integer tid);
}
