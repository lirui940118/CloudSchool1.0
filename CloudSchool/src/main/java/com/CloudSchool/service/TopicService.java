package com.CloudSchool.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Workmould;

public interface TopicService {
	int insertSelective(TopicWithBLOBs record,MultipartFile file);
	
	PageBean conditionsQueryTopci(Topic obj,Integer cur,Integer pagesize);
	
	int workTemplateCreate(Workmould obj);
}
