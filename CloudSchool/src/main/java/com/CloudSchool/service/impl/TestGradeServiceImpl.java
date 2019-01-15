package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.TestgradeMapper;
import com.CloudSchool.domain.statistics.KnowledgePointVO;
import com.CloudSchool.domain.statistics.TestInfo;
import com.CloudSchool.domain.statistics.TopicVo;
import com.CloudSchool.domain.statistics.testBaseInfo;
import com.CloudSchool.domain.statistics.testVO;
import com.CloudSchool.service.TestGradeService;

@Service
@Transactional
public class TestGradeServiceImpl implements TestGradeService{

	@Autowired
	TestgradeMapper testgradeMapper;
	
	
	@Override
	public List<testVO> querySimStudentTestGradeBySid(Integer sId,Integer gId) {
		return testgradeMapper.querySimStudentTestGradeBySid(sId,gId);
	}


	@Override
	public TestInfo queryAllKnowledagePointBySidAndtId(Integer sId, Integer tId) {
		List<TopicVo> list = testgradeMapper.queryAllKnowledagePointBySidAndtId(sId, tId);
		TestInfo testInfo = new TestInfo();
		//知识点分类下的题目集合
		List<KnowledgePointVO> KnowledgePointList = new ArrayList<KnowledgePointVO>();
		//上机题目集合
		List<TopicVo> applicationTopicList = new ArrayList<TopicVo>();
		
		
		
		//组装数据(以知识点区别)
		for (int i = 0; i < list.size(); i++) {
			//topicTypeId 1选择题 2简答题 3上机题
			//topicExamdotId = 考点类型(0识记,1理解) 不区分
			TopicVo topicVo = list.get(i);
			if(topicVo.getTopicTypeId()==3) {//3上机题
				applicationTopicList.add(topicVo);
			}else {//1选择题//2简答题
				if(KnowledgePointList.size() == 0) {
					KnowledgePointVO tempK = new KnowledgePointVO();
					tempK.setKnowledagePointId(topicVo.getKnowledagePointId());
					tempK.setKnowledagePointTopicScore(topicVo.getTopicScore());
					tempK.setKnowledagePointTopicTotalScore(topicVo.getTopicTotalScore());
					List<TopicVo> tempTopicList = new ArrayList<TopicVo>();
					tempTopicList.add(topicVo);
					tempK.setTopicList(tempTopicList);
					if(topicVo.getTopicExamdotId()== 0) {
						tempK.setUnderstandTopicScore(tempK.getUnderstandTopicScore()+topicVo.getTopicScore());
						tempK.setUnderstandTopicTotalScore(tempK.getUnderstandTopicTotalScore()+topicVo.getTopicTotalScore());
					}else if(topicVo.getTopicExamdotId()== 1) {
						tempK.setMemorizationTopicScore(tempK.getMemorizationTopicScore()+topicVo.getTopicScore());
						tempK.setMemorizationTopicTotalScore(tempK.getMemorizationTopicTotalScore()+topicVo.getTopicTotalScore());
					}
					KnowledgePointList.add(tempK);
					continue;
				}else {
					//判断是否已经存在是知识点
					for (int j = 0; j < KnowledgePointList.size(); j++) {
						KnowledgePointVO k = KnowledgePointList.get(j);
						if(k.getKnowledagePointId().equals(topicVo.getKnowledagePointId())) {
							//计算出该知识点总分和总得分
							k.setKnowledagePointTopicScore(k.getKnowledagePointTopicScore()+topicVo.getTopicScore());
							k.setKnowledagePointTopicTotalScore(k.getKnowledagePointTopicTotalScore()+topicVo.getTopicTotalScore());
							if(topicVo.getTopicExamdotId()== 0) {
								k.setUnderstandTopicScore(k.getUnderstandTopicScore()+topicVo.getTopicScore());
								k.setUnderstandTopicTotalScore(k.getUnderstandTopicTotalScore()+topicVo.getTopicTotalScore());
							}else if(topicVo.getTopicExamdotId()== 1) {
								k.setMemorizationTopicScore(k.getMemorizationTopicScore()+topicVo.getTopicScore());
								k.setMemorizationTopicTotalScore(k.getMemorizationTopicTotalScore()+topicVo.getTopicTotalScore());
							}
							k.getTopicList().add(topicVo);
							break;
						}else if(j==KnowledgePointList.size()-1) {//最后一项,没有找到知识点，新增一个
							KnowledgePointVO tempK = new KnowledgePointVO();
							tempK.setKnowledagePointId(topicVo.getKnowledagePointId());
							tempK.setKnowledagePointTopicScore(topicVo.getTopicScore());
							tempK.setKnowledagePointTopicTotalScore(topicVo.getTopicTotalScore());
							List<TopicVo> tempTopicList = new ArrayList<TopicVo>();
							tempTopicList.add(topicVo);
							tempK.setTopicList(tempTopicList);
							if(topicVo.getTopicExamdotId()== 0) {
								tempK.setUnderstandTopicScore(tempK.getUnderstandTopicScore()+topicVo.getTopicScore());
								tempK.setUnderstandTopicTotalScore(tempK.getUnderstandTopicTotalScore()+topicVo.getTopicTotalScore());
							}else if(topicVo.getTopicExamdotId()== 1) {
								tempK.setMemorizationTopicScore(tempK.getMemorizationTopicScore()+topicVo.getTopicScore());
								tempK.setMemorizationTopicTotalScore(tempK.getMemorizationTopicTotalScore()+topicVo.getTopicTotalScore());
							}
							KnowledgePointList.add(tempK);
							break;
						}
					}
				}
				
			}
			
		}
		testInfo.setKnowledgePointList(KnowledgePointList);
		testInfo.setApplicationTopicList(applicationTopicList);
		return testInfo;
	}


	@Override
	public testBaseInfo queryTestBaseInfoBySidAndtId(Integer sId, Integer tId) {
		return testgradeMapper.queryTestBaseInfoBySidAndtId(sId, tId);
	}

}
