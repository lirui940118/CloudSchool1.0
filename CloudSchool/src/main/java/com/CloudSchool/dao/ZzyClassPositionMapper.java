package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.ZzyClassPosition;

public interface ZzyClassPositionMapper {
    int insert(ZzyClassPosition record);

    int insertSelective(ZzyClassPosition record);
    
    //添加职位并且返回职位id
    public int insertPos(ZzyClassPosition record);
    
    //根据班级id查询班级的所有职位
    public List<ZzyClassPosition> queryByclid(Integer clid);
    
    //根据id删除职位
    public int deleteBypid(Integer pid);
}