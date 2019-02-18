package com.CloudSchool.dao;


import org.apache.ibatis.annotations.Param;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.ZzyEventType;

import com.CloudSchool.domain.ZzyRealtimeClassroom;

public interface ZzyRealtimeClassroomMapper {
    int insert(ZzyRealtimeClassroom record);

    int insertSelective(ZzyRealtimeClassroom record);

    /*学员课堂表现，统计用*/
    Integer queryRealtimeBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId);
 
    public List<ZzyEventType> queryByuid(Integer uid);
    
    public Integer queryByHuida(@Param("tid")Integer tid,@Param("sid")Integer sid,@Param("cid")Integer cid);
    public Integer queryByHuidaTure(@Param("tid")Integer tid,@Param("sid")Integer sid,@Param("cid")Integer cid);
    public Integer insertZidingyi(ZzyEventType ss);
    public Integer insertTSEid(ZzyRealtimeClassroom sss);
}