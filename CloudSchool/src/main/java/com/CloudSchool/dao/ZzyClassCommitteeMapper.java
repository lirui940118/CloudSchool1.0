package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyClassCommittee;

public interface ZzyClassCommitteeMapper {
    int insert(ZzyClassCommittee record);

    int insertSelective(ZzyClassCommittee record);
    
    //添加班委
    public int insertCom(ZzyClassCommittee record);
    
    //根据职位id查询班委
    public ZzyClassCommittee queryBypid(Integer pid);
    
    //根据id删除班委
    public int delteByccid(Integer ccid);
}