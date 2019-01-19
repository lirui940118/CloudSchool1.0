package com.CloudSchool.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.CloudSchool.service.MissionHistoryService;

@Controller
public class AddMissionTaskJob  extends Thread {
	@Autowired
	MissionHistoryService mhs;
	int i;
	String b;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Override
	public void run() {
		// 执行方法
		
	}
}
