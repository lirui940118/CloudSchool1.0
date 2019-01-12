package com.CloudSchool.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Topictype;
import com.CloudSchool.domain.Workmould;
import com.CloudSchool.service.TopicService;
import com.CloudSchool.service.TopicTypeService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("topicWarehouseController")
public class TopicWarehouseController {
	@Autowired
	TopicService topicService;
	@Autowired
	TopicTypeService topicTypeService;

	// 添加题目
	@RequestMapping("addTopic")
	@ResponseBody
	public int addTopic(String str,MultipartFile file) {
		TopicWithBLOBs Topic=JSON.parseObject(str, TopicWithBLOBs.class);	//题目复杂参数
		return topicService.insertSelective(Topic,file);
	}
	//跳转到题目添加
	@RequestMapping("TopageTopickAdd")
	public String TopageTopickAdd() {
		return "zjf/topickadd";
	}
 
	/*@RequestMapping("test")
	@ResponseBody
	public int test(MultipartFile file) {
		File f = new File("E:\\img\\word","c");
		if (!f.exists()) {
			f.mkdirs();
		} else {
			f.delete();
		}
		try {
			file.transferTo(new File("E:\\img\\word\\word"+file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}*/
	
	//跳转到布置作业页面
	@RequestMapping("toAppearTopicWork")
	public String toAppearTopicWork() {
		return "zjf/appearTopicWork";
	}
	
	//查询题目类型
	@RequestMapping("queryAllTopicType")
	@ResponseBody
	public List<Topictype> queryAllTopicType(){
		return topicTypeService.queryTopicTypeAll();
	}
	
	//根据条件查询题目(多条件)
	@RequestMapping("conditionsQueryTopci")
	@ResponseBody
	public PageBean conditionsQueryTopci(Topic obj,Integer cur){
		if(cur==null) {
			cur=1;
		}
		Integer pagesize=2;
		return topicService.conditionsQueryTopci(obj,cur,pagesize);
	}
	
	
	//作业模板生成
	@RequestMapping("workTemplateCreate")
	@ResponseBody
	public int workTemplateCreate(@RequestBody Workmould obj) {
		return topicService.workTemplateCreate(obj);
	}
	
	
	//跳转到发布作业
	@RequestMapping("toPublishWork")
	public String toPublishWork() {
		return "zjf/publishWork";
	}
	
}
