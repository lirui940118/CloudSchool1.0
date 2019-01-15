package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjUser;

public interface CqjMoudelService {
	//通过用户找出可以显示的模块 已经自动组合过的数据
	CqjUser queryByUser(CqjUser userinfo);
	//通过角色id和职位id找出可以显示的模块
	List<CqjModule> queryByRoleidandPositionid(Integer roleid, Integer positionid);
	
	List<CqjModule> queryAllModuleByRoleid(Integer roleid);

	List<CqjModule> queryAllInfoModuleByPositionid(Integer positionid);

	List<CqjModule> queryInfoModuleByPositionid(Integer positionid);
	
    List<CqjModule> queryModule();
    List<CqjModule> queryInfoModule();

}
