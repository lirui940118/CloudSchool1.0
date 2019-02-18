package com.CloudSchool.service;

import java.text.ParseException;

import com.CloudSchool.domain.ZzyClassSchedule;

public interface ZzyClassScheduleService {

	public int paike(int year,int wekk) throws ParseException;
	
	public ZzyClassSchedule queryBytidAndtime(Integer tid);
	
	public Integer insertkebiao(ZzyClassSchedule ins);
	
}
