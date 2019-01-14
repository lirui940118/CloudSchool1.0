package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.GkKaoqinStateMapper;
import com.CloudSchool.domain.GkKaoqinState;
import com.CloudSchool.service.GkKaoqinStateService;
@Service
public class GkKaoqinStateServiceImpl implements GkKaoqinStateService{

	@Autowired
	GkKaoqinStateMapper gkKaoqinStateMapper;
	@Override
	public List<GkKaoqinState> queryKqTotalInfoBySidAndGid(Integer sId, Integer gId) {
		return gkKaoqinStateMapper.queryKqTotalInfoBySidAndGid(sId, gId);
	}

}
