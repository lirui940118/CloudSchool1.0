package com.CloudSchool.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ZzyEventType;
import com.CloudSchool.domain.ZzyRealtimeClassroom;

public interface ZzyRealtimeClassroomService {
	
	 /*学员课堂表现，统计用*/
     Integer queryRealtimeBysIdAndgId(Integer sId,Integer gId);
	 public List<ZzyEventType> queryByuid(Integer uid);
	 public Integer queryByHuida(Integer tid,Integer sid,Integer cid);
	 public Integer queryByHuidaTure(Integer tid,Integer sid,Integer cid);
	 public Integer insertZidingyi(ZzyEventType ss);
	 public Integer insertTSEid(ZzyRealtimeClassroom sss);
}
