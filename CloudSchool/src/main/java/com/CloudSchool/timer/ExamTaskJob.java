package com.CloudSchool.timer;

import org.springframework.stereotype.Controller;

@Controller
public class ExamTaskJob extends Thread {
	// 此类为定时器模板
	// 如果方法需要带参数则通过set复制属性 自己定义属性然后设置set get 方法
	int i;
	String b;
	
	public ExamTaskJob() {
		// TODO Auto-generated constructor stub
	}

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
		System.out.println("扫描考试表..........."+i+","+b);
		//在方法执行完之后将值属性清空
	}

}
