package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ZzySectionMapper;
import com.CloudSchool.domain.ZzySection;
import com.CloudSchool.service.ZzySectionService;
@Service
@Transactional
public class ZzySectionServiceImpl implements ZzySectionService{
	
	@Autowired
	ZzySectionMapper zzySectionMapper;
	@Override
	public List<ZzySection> queryBycid(Integer cid) {
		// TODO Auto-generated method stub
		return zzySectionMapper.queryBycid(cid);
	}

}
