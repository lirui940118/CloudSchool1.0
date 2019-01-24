package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.CqjStaffMapper;
import com.CloudSchool.domain.statistics.StaffBaseVO;
import com.CloudSchool.service.CqjStaffService;
@Service
public class CqjStaffServiceImpl implements CqjStaffService{

	@Autowired
	CqjStaffMapper cqjStaffMapper;
	
	
	@Override
	public StaffBaseVO queryStaffBaseVOBySid(Integer staffId) {
		return cqjStaffMapper.queryStaffBaseVOBySid(staffId);
	}

}
