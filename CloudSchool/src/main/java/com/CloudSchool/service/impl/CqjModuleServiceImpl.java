package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.CqjModuleMapper;
import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjMoudelService;
@Service
@Transactional
public class CqjModuleServiceImpl implements CqjMoudelService{
	@Autowired
	CqjModuleMapper cmm;

	@Override
	public CqjUser queryByRoleidandPositionid(CqjUser userinfo, Integer roleid, Integer positionid) {
		// TODO Auto-generated method stub
		List<CqjModule> alllist = cmm.queryByRoleidandPositionid(userinfo.getRoleid(), userinfo.getPositionid());
		List<CqjModule> moduleSettingList = new ArrayList<CqjModule>();
		List<CqjModule> moduleList = new ArrayList<CqjModule>();
		List<CqjModule> moduleInfoList = new ArrayList<CqjModule>();
		for (CqjModule list : alllist) {
			if (list.getPid() == 0) {
				for (CqjModule clist : alllist) {
					if(clist.getPid()!=0) {
						if(clist.getPid()==list.getModuleid()) {
							list.getMlist().add(clist);
						}
					}
				}
				if(list.getLeftmenu()==0) {
					moduleList.add(list);
				}
				if(list.getLeftmenu()==1) {
					moduleSettingList.add(list);
				}
			}
			if(list.getLeftmenu()==2) {
				moduleInfoList.add(list);
			}
		}
		userinfo.setModuleAllList(alllist);
		userinfo.setModuleList(moduleList);
		userinfo.setModuleInfoList(moduleInfoList);
		userinfo.setModuleSettingList(moduleSettingList);
		return userinfo;
	}

	@Override
	public List<CqjModule> queryAllModule(Integer roleid) {
		// TODO Auto-generated method stub
		CqjModule allModule = new CqjModule();
		allModule.setModuleid(0);
		allModule = digui(allModule, cmm.queryAllModule(roleid));
		return allModule.getMlist();
	}

	@Override
	public List<CqjModule> queryAllInfoModule(Integer positionid) {
		// TODO Auto-generated method stub
		/*List<CqjModule> alllist =cmm.queryAllInfoModule(positionid);
		List<CqjModule> infoModule=new ArrayList<CqjModule>();
		for (CqjModule list : alllist) {
			//判断父级0
			if (list.getPid() == 0) {
				for (CqjModule clist : alllist) {
					//将不为0的查出，并且父级节点是上一级的
					if(clist.getPid()!=0&&clist.getPid()==list.getModuleid()) {
						list.getMlist().add(clist);
						for (CqjModule cclist : alllist) {
							if(cclist.getPid()!=0&&cclist.getPid()==clist.getModuleid()) {
								clist.getMlist().add(cclist);
							}		
						}	
					}
				}
				infoModule.add(list);
			}
			
		}
		System.out.println(infoModule);*/
		CqjModule allModule = new CqjModule();
		allModule.setModuleid(0);
		allModule = digui(allModule, cmm.queryAllInfoModule(positionid));
		return allModule.getMlist();
	}

	public CqjModule digui(CqjModule cqjModule,List<CqjModule> alllist){
		for (CqjModule ccm : alllist) {
			if(ccm.getPid()==cqjModule.getModuleid()) {
				ccm = digui(ccm, alllist);
				cqjModule.getMlist().add(ccm);
			}		
		}
		return cqjModule;
	}

	@Override
	public List<CqjModule> queryInfoModule(Integer positionid) {
		// TODO Auto-generated method stub
		return cmm.queryInfoModule(positionid);
	}
	

	

}
