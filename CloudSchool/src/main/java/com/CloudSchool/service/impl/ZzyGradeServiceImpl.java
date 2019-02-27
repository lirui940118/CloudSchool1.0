package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.statistics.GradeVO;
import com.CloudSchool.service.ZzyGradeService;
@Service
public class ZzyGradeServiceImpl implements ZzyGradeService{

	@Autowired
	ZzyGradeMapper zzyGradeMapper;
	@Override
	public List<ZzyGrade> queryGradeListBySid(Integer sId) {
		return zzyGradeMapper.queryGradeListBySid(sId);
	}
	@Override
	public ZzyGrade queryCurrentGradeBySid(Integer sId) {
		return zzyGradeMapper.queryCurrentGradeBySid(sId);
	}
	@Override
	public List<ZzyGrade> queryByvid(Integer vid) {
		return zzyGradeMapper.queryByvid(vid);
	}
	@Override
	public List<ZzyGrade> queryAll() {
		// TODO Auto-generated method stub
		return zzyGradeMapper.queryAll();
	}
	@Override
	public List<GradeVO> queryAllGradePcClazz(Integer gId, String pc) {
		return zzyGradeMapper.queryAllGradePcClazz(gId, pc);
	}
	@Override
	public List<ZzyGrade> queryGradeAndClazz() {
		// TODO Auto-generated method stub
		return zzyGradeMapper.queryGradeAndClazz();
	}

}
