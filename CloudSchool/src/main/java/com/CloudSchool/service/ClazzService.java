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
	//分配班级名称 0入学新班-自动分配新的编号名(array数组填null)，1升学开班-继承原班名(array数组填必填，否则自动分配新的编号名)
	public String getClazzName(int id,int[] array);
	//分配班级名称 0入学新班-自动分配新的编号名(array数组填null)，1升学开班-继承原班名(array数组填必填，否则自动分配新的编号名)
	public String getClazzPC(int gid);

}
