package com.CloudSchool.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.CloudSchool.dao.TopicMapper;
import com.CloudSchool.dao.TopicoptionMapper;
import com.CloudSchool.dao.WorkinfoMapper;
import com.CloudSchool.dao.WorkmouldMapper;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Topicoption;
import com.CloudSchool.domain.Workmould;
import com.CloudSchool.service.TopicService;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {
	@Autowired
	TopicMapper topicMapper;
	@Autowired
	TopicoptionMapper topicoptionMapper;

	@Autowired
	WorkmouldMapper workmouldMapper;

	@Autowired
	WorkinfoMapper workinfoMapper;

	@Override
	// 添加题目
	public int insertSelective(TopicWithBLOBs record, MultipartFile file) {
		// 添加选择题题目
		if (record.getTid() == 1) {
			int i = topicMapper.insertSelective(record);
			if (i > 0) {
				List<Topicoption> list = record.getList(); // 所有题目
				Map<String, Object> obj = new HashMap<String, Object>();
				obj.put("tid", record.getId());
				obj.put("list", list);
				return topicoptionMapper.insertList(obj);
			}
		}
		// 上机题目新增 上传附件
		if (record.getTid() == 3) {
			UUID u = UUID.randomUUID();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			// 文件名称
			String filename = df.format(new Date()).toString().replace("-", "").replace(":", "").replace(" ", "")
					+ u.toString().substring(0, 8);
			File f = new File("E:\\img\\word");
			if (!f.exists()) {
				f.mkdirs();
			} else {
				f.delete();
			}
			try {
				file.transferTo(new File(f, filename + file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				record.setUrl(filename);
				record.setTopicconten("上机题目(请参考附件)");
				record.setAnalysis("无解析");
				return topicMapper.insertSelective(record);
			}

		}
		return topicMapper.insertSelective(record);
	}

	// 多条件查询题目
	@Override
	public PageBean conditionsQueryTopci(Topic obj, Integer cur, Integer pagesize) {
		// TODO Auto-generated method stub
		PageBean page = new PageBean(topicMapper.queryCount(obj), pagesize,
				topicMapper.conditionsQueryTopci(obj, (cur - 1) * pagesize, pagesize), cur);
		return page;
	}

	// 生成作业模板
	@Override
	public int workTemplateCreate(Workmould obj) {
		//生成作业的类型    选择题 阅读题 上机题  混合题
		Integer[] array = workmouldMapper.queryWorkMouldType(obj);
		for (int j = 0; j < array.length; j++) {
			/*选择题*/
			if (array.length == 1 && array[0] == 1) {
				obj.setWtype(0);
				break;
			}
			/*阅读题*/
			if (array.length == 1 && array[0] == 2) {
				obj.setWtype(1);
				break;
			}
			/*上机题*/
			if (array.length == 1 && array[0] == 3) {
				obj.setWtype(2);
				break;
			}
			/*混合题*/
			if(array.length>1) {
				obj.setWtype(3);
			}
		}
		int i = workmouldMapper.insertSelective(obj);
		if (i > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("wid", obj.getId());
			map.put("ids", obj.getIds());
			System.out.println(obj.getId());
			return workinfoMapper.insertListByMap(map);
		}
		return 0;
	}
	
	
	//根据题目id查询题目
	@Override
	public TopicWithBLOBs queryTopicById(Integer id) {
		// TODO Auto-generated method stub
		return topicMapper.queryTopicById(id);
	}

}
