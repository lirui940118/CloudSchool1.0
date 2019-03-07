package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.CqjModuleMapper;
import com.CloudSchool.dao.CqjParentsMapper;
import com.CloudSchool.dao.CqjStaffMapper;
import com.CloudSchool.dao.CqjStudentMapper;
import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjParents;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.service.CqjUserService;

@Service
@Transactional
public class CqjUserServiceImpl implements CqjUserService {
	@Autowired
	CqjUserMapper cum;
	@Autowired
	CqjModuleMapper cmm;
	@Autowired
	CqjStaffMapper csfm;
	@Autowired
	CqjStudentMapper csm;
	@Autowired
	CqjParentsMapper cpm;
	@Override
	public CqjUser login(String username, String password) {
		// TODO Auto-generated method stub
		CqjUser userinfo = cum.login(username, password);
		if (userinfo != null) {
			String[] clazzids = cum.queryClazzByPositionid(userinfo.getPositionid());
			String[] strClazzids = userinfo.getClazzids().length() > 0 ? userinfo.getClazzids().split(",")
					: new String[0];
			String[] c = new String[clazzids.length + strClazzids.length];
			System.arraycopy(clazzids, 0, c, 0, clazzids.length);
			System.arraycopy(strClazzids, 0, c, clazzids.length, strClazzids.length);
			List<String> clazzidsList = new ArrayList<String>();
			for (int i = 0; i < c.length; i++) {
				if (!clazzidsList.contains(c[i])) {
					clazzidsList.add(c[i]);
				}
			}
			if(userinfo.getUsertypenub()==1) {
				userinfo.setStandby1(csm.queryVidByStudentid(userinfo.getUsertypeid())+"");
			}
			userinfo.setClazzidsList(clazzidsList);
		}
		return userinfo;
	}

	@Override
	public CqjUser queryByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return cum.queryByUserid(userid);
	}

	@Override
	public PageBean pageUser(String filtrate, Integer cur, Integer pageSize) {
		// TODO Auto-generated method stub
		int count=cum.queryCunt(filtrate);
		int cur1=(cur-1)*pageSize;
		List<CqjUser> list=cum.pageUser(filtrate,cur1, pageSize);
		PageBean page=new PageBean(count, pageSize,list , cur);
		return page;
	}

	@Override
	public int updateUser(CqjUser user) {
		int i=cum.updateByPrimaryKeySelective(user);
		int z=0;
		if(user.getUsertypenub()==0) {
			CqjStaff staff=new CqjStaff();
			staff.setPositionid(user.getPositionid());
			staff.setStaffname(user.getName());
			staff.setStaffid(user.getUsertypeid());
			z=csfm.updateByPrimaryKeySelective(staff);
		}
		
		if(user.getUsertypenub()==1) {
			CqjStudent student=new CqjStudent();
			student.setPositionid(user.getPositionid());
			student.setStudentname(user.getName());
			student.setStudentid(user.getUsertypeid());
			z=csm.updateByPrimaryKeySelective(student);
		}
		
		if(user.getUsertypenub()==2) {
			CqjParents parents=new CqjParents();
			parents.setPositionid(user.getPositionid());
			parents.setParentsname(user.getName());
			parents.setParentsid(user.getUsertypeid());
			z=cpm.updateByPrimaryKeySelective(parents);
		}
		return z;
	}

	@Override
	public List<CqjUser> queryUseridByCid(Integer cid) {
		// TODO Auto-generated method stub
		return cum.queryUseridByCid(cid);
	}

	@Override
	public List<CqjUser> queryJZuseridBycid(Integer cid) {
		// TODO Auto-generated method stub
		return cum.queryJZuseridBycid(cid);
	}

	@Override
	public List<CqjUser> queryAllJiaoYuan() {
		// TODO Auto-generated method stub
		return cum.queryAllJiaoYuan();
	}

	@Override
	public CqjUser queryWJcsjfPD() {
		// TODO Auto-generated method stub
		return cum.queryWJcsjfPD();
	}


}
