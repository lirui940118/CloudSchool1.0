package com.CloudSchool.service;

import java.util.List;


import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.domain.statistics.ClazzBaseInfoVO;

public interface ClazzService {
	public int CreateClass(ClazzInfo c);
	

	 //根据班级id集合 查询班级数据
	public List<Clazz> queryListid(List<String> list);
	
	//根据班级id查询班级 以及查询班主任对象以及教员集合
	public Clazz queryByid(Integer id);

	//write by lirui
	public List<ClazzBaseInfoVO> queryClazzBaseInfo(Integer clazzId);
	//write by lirui
	public List<ClazzBaseInfoVO> queryClazzListByStaffId(Integer staffId);
	
	List<Clazz> queryByClazzidAllStu(Integer[] clazzs);

}
