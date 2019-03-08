package com.CloudSchool.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ZzyClassSchedule;

public interface ZzyClassScheduleService {

	public int paike(int year,int wekk) throws ParseException;
	
	public ZzyClassSchedule queryBytidAndtime(Integer tid);
	
	public Integer insertkebiao(ZzyClassSchedule ins);
	
	 public List<Clazz> queryKbBytime(int year,int wekk) throws ParseException;
	 
	 //根据班级id和当前时间获取班级本周课表
	 public List<ZzyClassSchedule> gjbjqxkb(Integer cid) throws ParseException;
	 
	 public List<ZzyClassSchedule> anzhouckb(int year,int wekk,Integer cid) throws ParseException;
	 
	 
	 public Integer queryShengxue(Integer cid) throws ParseException;
	 
	 public Integer updateuser1();
	    
	 public Integer deleteByuser1();
	 
	 
	 
	 
	
}
