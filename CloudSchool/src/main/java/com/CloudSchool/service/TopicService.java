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

public interface TopicService {
	int insertSelective(TopicWithBLOBs record,MultipartFile file);
	
	PageBean conditionsQueryTopci(Topic obj,Integer cur,Integer pagesize);
	
	int workTemplateCreate(Workmould obj);
	
	/*当前课程进度下应该答题总数*/
	Integer queryCurrentTotalTopicCountBysIdAndGid(Integer sId,Integer gId,Integer eId);
	/*当前课程进度下学员的实际答题量*/
    Integer queryCurrentRealTotalTopicCountBysIdAndgId(Integer sId,Integer gId,Integer eId);
    /*当前进度下刷题正确率*/
    Integer queryCurrentTotalTopicAccuracyBysIdAndgId(Integer sId,Integer gId,Integer eId);
    /*当前进度下，上机题目正确率*/
    Integer queryApplicationAbilityRateBysIdAndgId(Integer sId, Integer gId,Integer tId);
}
