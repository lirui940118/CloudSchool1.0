package com.CloudSchool.dao;



import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ZzyClassSchedule;

public interface ZzyClassScheduleMapper {
    int insert(ZzyClassSchedule record);

    int insertSelective(ZzyClassSchedule record);
    
    public Integer queryClidAndCid(@Param("clid")Integer clid,@Param("cid")Integer cid);
    
    public Integer queryByyoukong(@Param("tid")Integer tid,@Param("time")Date time,@Param("temporal_interva")Integer temporal_interva);
    
    
    public ZzyClassSchedule  queryByOneY(@Param("tid")Integer tid,@Param("time")String time,@Param("temporal_interva")Integer temporal_interva);
   
    
    public Integer insertkebiao(ZzyClassSchedule ins);
    
    public Integer querySjAndXx(@Param("time")String time,@Param("clid")Integer clid);
    
    public Integer update(@Param("clid")Integer clid,@Param("time")Date time);
    
    public List<ZzyClassSchedule> queryKbBytime(@Param("stime")Date stime,@Param("etime")Date etime,@Param("clid") Integer clid);
}