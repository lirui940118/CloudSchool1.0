package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.PageBean;

public interface CqjUserService {
    CqjUser login(String username,String password);
    CqjUser queryByUserid(Integer userid);
    PageBean pageUser(String filtrate,Integer cur,Integer pageSize);
    int updateUser(CqjUser user);
	//gk通过班级id查询所有学生userid
	List<CqjUser> queryUseridByCid(Integer cid);
	//gk通过班级id查询家长userid
	List<CqjUser> queryJZuseridBycid(Integer cid);
	//gk查询所有教员
	List<CqjUser> queryAllJiaoYuan();
	//gk判断是否为调查教员问卷，true带出zid
	CqjUser queryWJcsjfPD();
}
