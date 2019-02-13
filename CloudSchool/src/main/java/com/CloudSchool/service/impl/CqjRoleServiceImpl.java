package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.CqjRoleMapper;
import com.CloudSchool.dao.CqjRoleModuleMapper;
import com.CloudSchool.domain.CqjRole;
import com.CloudSchool.service.CqjRoleService;


@Service
@Transactional
public class CqjRoleServiceImpl implements CqjRoleService {
	@Autowired
	CqjRoleMapper crm;
	@Autowired
	CqjRoleModuleMapper crmm;
	
	@Override
	public List<CqjRole> queryAllRole() {
		// TODO Auto-generated method stub
		return crm.queryAllRole();
	}

	@Override
	public int updateRoleAndModule(Integer roleid, String[] result) {
		// TODO Auto-generated method stub
		int i=crmm.deleteByRoleId(roleid);
		if(result.length>0) {
			return crmm.addByRoleIdAndModuleid(roleid, result);
		}
		return i;
	}

	@Override
	public int addRole(CqjRole record, String[] arry) {
		crm.insertSelective(record);
		if(arry.length>0) {
			crmm.addByRoleIdAndModuleid(record.getRoleid(), arry);
		}
		return 0;
	}



}
