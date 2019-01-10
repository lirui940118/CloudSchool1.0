package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.CqjModuleMapper;
import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjUserService;

@Service
@Transactional
public class CqjUserServiceImpl implements CqjUserService {
	@Autowired
	CqjUserMapper cum;
	@Autowired
	CqjModuleMapper cmm;
	@Override
	public CqjUser login(String username, String password) {
		// TODO Auto-generated method stub
		CqjUser userinfo = cum.login(username, password);
		if (userinfo != null) {
			String[] clazzids = cum.queryClazzByPositionid(userinfo.getPositionid());
			String[] strClazzids = 
					userinfo.getClazzids().length()>0? userinfo.getClazzids().split(","):new String[0];
			String[] c = new String[clazzids.length + strClazzids.length];
			System.arraycopy(clazzids, 0, c, 0, clazzids.length);
			System.arraycopy(strClazzids, 0, c, clazzids.length, strClazzids.length);
			List<String> clazzidsList = new ArrayList<String>();
			for (int i=0; i<c.length; i++) {
			  if(!clazzidsList.contains(c[i])) {
				  clazzidsList.add(c[i]);
			  }
			}
			
			List<CqjModule> mlist=cmm.queryByRoleidandPositionid(userinfo.getRoleid(), userinfo.getPositionid());
			userinfo.setClazzidsList(clazzidsList);
			userinfo.setModuleList(mlist);
		}
		return userinfo;
	}
}
