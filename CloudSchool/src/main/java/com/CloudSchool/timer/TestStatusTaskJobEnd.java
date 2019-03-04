package com.CloudSchool.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CloudSchool.dao.ParticipatetestclassMapper;
import com.CloudSchool.domain.Participatetestclass;
@Component
public class TestStatusTaskJobEnd extends Thread{
	Participatetestclass obj;
	@Autowired
	ParticipatetestclassMapper participatetestclassMapper;
	public void zzz(Participatetestclass obj) {
		this.obj=obj;
	}
	@Override
	public void run() {
		System.out.println("调用了"+this.obj.getTid()+"修改状态"+this.obj.getStatus());
		participatetestclassMapper.updateTestStatusTime(obj);
	}
}
