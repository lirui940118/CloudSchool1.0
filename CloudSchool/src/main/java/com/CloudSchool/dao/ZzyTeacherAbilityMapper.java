package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.ZzyTeacherAbility;

public interface ZzyTeacherAbilityMapper {
    int insert(ZzyTeacherAbility record);

    int insertSelective(ZzyTeacherAbility record);
    public List<ZzyTeacherAbility>  queryBytid( Integer tid);
    
    public Integer insertTea(List<ZzyTeacherAbility> list);
    
    public Integer deleteAllBytid(Integer tid);
    
    public Integer updateStaffBytid(Integer tid);
}