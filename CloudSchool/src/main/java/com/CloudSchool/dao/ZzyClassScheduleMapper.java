package com.CloudSchool.dao;



import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ZzyClassSchedule;

public interface ZzyClassScheduleMapper {
    int insert(ZzyClassSchedule record);

    int insertSelective(ZzyClassSchedule record);
    
    public Integer queryClidAndCid(@Param("clid")Integer clid,@Param("cid")Integer cid);
    
    public Integer queryByyoukong(@Param("tid")Integer tid,@Param("time")Date time,@Param("temporal_interva")Integer temporal_interva);
    
    
    public ZzyClassSchedule  queryByOneY(@Param("tid")Integer tid,@Param("time")String time,@Param("temporal_interva")Integer temporal_interva);
   
    
    public Integer insertkebiao(ZzyClassSchedule ins);
       
    // 查询time(这一天)没课的老师  （赵举峰）
    int queryBytimeTeach(@Param("tid")Integer tid,@Param("time")Date time);
}