package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ZzyClassCommitteeMapper;
import com.CloudSchool.dao.ZzyClassPositionMapper;
import com.CloudSchool.domain.ZzyClassCommittee;
import com.CloudSchool.domain.ZzyClassPosition;
import com.CloudSchool.service.ZzyClassPositionService;

@Service
public class ZzyClassPositionServiceimpl implements ZzyClassPositionService{

		@Autowired
		ZzyClassPositionMapper pos;
		
		@Autowired
		ZzyClassCommitteeMapper com;

		@Override
		public int insertPos(List<ZzyClassPosition> list) {
			// TODO Auto-generated method stub
			for (ZzyClassPosition zzyClassPosition : list) {
				pos.insertPos(zzyClassPosition);
				ZzyClassCommittee n= new ZzyClassCommittee();
				n.setPdi(zzyClassPosition.getPid());
				n.setSid(zzyClassPosition.getCom().getSid());
				com.insertCom(n);
			}
			return 1;
		}

		@Override
		public List<ZzyClassPosition> queryByclid(Integer clid) {
			// TODO Auto-generated method stub
			return pos.queryByclid(clid);
		}

		@Override
		public int deleteBypid(Integer pid) {
			// TODO Auto-generated method stub
			return pos.deleteBypid(pid);
		}
}
