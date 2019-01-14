package com.CloudSchool.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.CloudSchool.domain.TopicWithBLOBs;

@RequestMapping("topicWarehouseController")
public class TopicWarehouseController {
	//添加题目
	@RequestMapping("addTopic")
	public int addTopic(TopicWithBLOBs record) {
		return 0;
	}
}
