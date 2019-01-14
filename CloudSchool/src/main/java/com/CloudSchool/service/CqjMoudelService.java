package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjUser;

public interface CqjMoudelService {
	CqjUser queryByRoleidandPositionid(CqjUser userinfo, Integer roleid, Integer positionid);

	List<CqjModule> queryAllModuleByRoleid(Integer roleid);

	List<CqjModule> queryAllInfoModuleByPositionid(Integer positionid);

	List<CqjModule> queryInfoModuleByPositionid(Integer positionid);
	
    List<CqjModule> queryModule();
    List<CqjModule> queryInfoModule();

}
