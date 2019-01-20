package com.CloudSchool.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzSMapper;
import com.CloudSchool.domain.statistics.StudentInfoVO;
import com.CloudSchool.service.ClazzSService;
@Service
@Transactional
public class ClazzSServiceImpl implements ClazzSService{

	@Autowired
	ClazzSMapper clazzSMapper;
	@Override
	public List<StudentInfoVO> queryStudentTestVoBySidsAndTid(Integer clazzId,Integer staffId,Integer sortType) {
		List<StudentInfoVO> list = clazzSMapper.queryStudentTestVoBySidsAndTid(clazzId,staffId);
		//算出平均分
		Double averageScore = 0.0;
		Integer count = 0;
		for(int i= 0;i<list.size();i++) {//学员
			averageScore = 0.0;//初始化
			count=0;
			for(int j=0;j<list.get(i).getTestList().size();j++) {//考试集合
				averageScore +=list.get(i).getTestList().get(j).getStudentScore();
				count++;
			}
			list.get(i).setAverageScore(averageScore/count);
		}
		//平均分名次
		StudentInfoVO.sortType = -1;
		Collections.sort(list);
		for(int i= 0;i<list.size();i++) {
			list.get(i).setAverageNo(i+1);
		}
		
		//排序内容
		if(sortType == -1) {
			return list;
		}else {
			//按第N次考试排序
			StudentInfoVO.sortType = sortType;
			Collections.sort(list);
			return list;
		}
	}

}
