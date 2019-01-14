package com.CloudSchool.service;

import java.util.List;


import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzcourseteacher;

public interface ClazzService {
	public int CreateClass(ClazzInfo c);
	

	 //根据班级id集合 查询班级数据
	public List<Clazz> queryListid(List<String> list);
}
