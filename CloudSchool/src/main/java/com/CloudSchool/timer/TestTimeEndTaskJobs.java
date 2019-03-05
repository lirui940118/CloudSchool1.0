package com.CloudSchool.timer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CloudSchool.dao.ParticipateteststuMapper;
import com.CloudSchool.dao.TestgradeMapper;
import com.CloudSchool.domain.Participateteststu;
import com.alibaba.fastjson.JSON;

@Component
public class TestTimeEndTaskJobs extends Thread{
	Integer tid;
	public void setObjValue(Integer tid) {
		this.tid=tid;
	}
	@Autowired
	ParticipateteststuMapper participateteststuMapper;
	
	@Autowired
	TestgradeMapper testgradeMapper;
	@Override
	public void run() {
		//查询出这场考试没有交卷的学生
		Integer[] array=participateteststuMapper.queryByTidAndStatusAll(tid);
		if(array.length>0) {
			System.out.println(JSON.toJSONString(array));
			for (Integer integer : array) {
				//修改作业为已批该状态
				Participateteststu obj=new Participateteststu();
				obj.setUser3("3");
				obj.setSid(integer);
				obj.setTid(tid);
				participateteststuMapper.updateUser3ByTidAndSid(obj);
			}
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("tid", this.tid);
			map.put("list",array);
			testgradeMapper.inserList(map);
		}
	}
}
