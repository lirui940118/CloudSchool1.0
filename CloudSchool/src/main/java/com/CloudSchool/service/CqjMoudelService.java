package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjUser;

public interface CqjMoudelService {
	CqjUser queryByRoleidandPositionid(CqjUser userinfo, Integer roleid, Integer positionid);

	List<CqjModule> queryAllModule(Integer roleid);

	List<CqjModule> queryAllInfoModule(Integer positionid);

	List<CqjModule> queryInfoModule(Integer positionid);

}
