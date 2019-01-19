package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ZzyClassCommitteeMapper;
import com.CloudSchool.service.ZzyClassCommitteeService;

@Service
public class ZzyClassCommitteeServiceimpl implements ZzyClassCommitteeService{

		@Autowired
		ZzyClassCommitteeMapper comm;

		@Override
		public int delteByccid(Integer ccid) {
			// TODO Auto-generated method stub
			return comm.delteByccid(ccid);
		}
}
