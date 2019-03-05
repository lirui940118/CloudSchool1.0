package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzySection;

public interface ZzySectionService {
	//根据课程查询章节(赵举峰)
	 public List<ZzySection> queryBycid(Integer cid);
	 
	 List<ZzySection> queryAllSection();
}
