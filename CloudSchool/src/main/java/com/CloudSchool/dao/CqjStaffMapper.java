package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjStaff;

public interface CqjStaffMapper {
    int deleteByPrimaryKey(Integer staffid);

    int insert(CqjStaff record);

    int insertSelective(CqjStaff record);

    CqjStaff selectByPrimaryKey(Integer staffid);

    int updateByPrimaryKeySelective(CqjStaff record);

    int updateByPrimaryKey(CqjStaff record);
}