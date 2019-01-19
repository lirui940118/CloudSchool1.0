package com.CloudSchool.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddScoreTaskJob extends Thread {
	int i=2;
	int z=3;
	public void zzz(int i,int z) {
		this.i=i;
		this.z=z;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(i+","+z);
	}
}
