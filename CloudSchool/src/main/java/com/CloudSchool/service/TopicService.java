package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Workmould;
import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.zjfvo.TopicParam;

public interface TopicService {
	int insertSelective(TopicWithBLOBs record,MultipartFile file);
	
	PageBean conditionsQueryTopci(TopicParam obj,Integer cur,Integer pagesize);
	
	int workTemplateCreate(Workmould obj);
	
	/*当前课程下学员的实际答题量rate*/
    Integer queryRealTopicRateBysIdAndgId(Integer sId,Integer gId,Integer eId);
    /*当前课程下刷题正确率*/
    Integer queryCurrentTotalTopicAccuracyBysIdAndgId(Integer sId,Integer gId,Integer eId);
}
