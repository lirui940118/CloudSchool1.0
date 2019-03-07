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
       
    // 查询time(这一天)没课的老师  （赵举峰）
    int queryBytimeTeach(@Param("tid")Integer tid,@Param("time")Date time);
    
    public ZzyClassSchedule queryBydansk(@Param("clid") Integer clid,@Param("time") Date time);
    
    public Integer queryByyouyouyou(@Param("clid") Integer clid,@Param("time") Date time);
    
    public List<ZzyClassSchedule> queryBycidH(Integer cid);
}