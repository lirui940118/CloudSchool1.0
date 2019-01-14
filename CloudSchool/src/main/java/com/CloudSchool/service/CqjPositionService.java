package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjPosition;

public interface CqjPositionService {
    List<CqjPosition> qeuryAllposition();
    int updatePositionAndModule(Integer positionid,String[] result);
}
