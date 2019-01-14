package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.CqjPositionMapper;
import com.CloudSchool.dao.CqjPositionModuleMapper;
import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.service.CqjPositionService;

@Service
@Transactional
public class CqjPositionServiceImpl implements CqjPositionService{
	@Autowired
	CqjPositionMapper cpm;
	@Autowired
	CqjPositionModuleMapper cpmm;
	@Override
	public List<CqjPosition> qeuryAllposition() {
		// TODO Auto-generated method stub
		return cpm.qeuryAllposition();
	}

	@Override
	public int updatePositionAndModule(Integer positionid, String[] result) {
		// TODO Auto-generated method stub
		cpmm.deleteByPositionId(positionid);
		if(result.length>0) {
			cpmm.addByPositionIdAndModuleid(positionid, result);
		}
		return 0;
	}

}
