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
	
}
