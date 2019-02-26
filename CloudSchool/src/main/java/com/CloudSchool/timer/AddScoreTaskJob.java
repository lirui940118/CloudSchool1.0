package com.CloudSchool.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.CloudSchool.dao.ParticipationworkclassMapper;

@Controller
public class AddScoreTaskJob extends Thread {
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
		participationworkclassMapper.updateStatusList(status, wid);
	}
}
