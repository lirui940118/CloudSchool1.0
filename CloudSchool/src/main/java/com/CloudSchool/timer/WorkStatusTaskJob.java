package com.CloudSchool.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CloudSchool.dao.ParticipationworkclassMapper;
@Component
public class WorkStatusTaskJob extends Thread {
	int status;
	int wid;
	@Autowired
	ParticipationworkclassMapper participationworkclassMapper;
	public void zzz(int status,int wid) {
		this.status=status;
		this.wid=wid;
	}
	@Override
	public void run() {
		System.out.println("调用了"+wid+"修改状态"+status);
		participationworkclassMapper.updateStatusList(status, wid);
	}
}
