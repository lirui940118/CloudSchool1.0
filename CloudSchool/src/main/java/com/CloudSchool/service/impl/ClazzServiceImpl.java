package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.ClazzcourseteacherMapper;
import com.CloudSchool.dao.ClazzstudentMapper;
import com.CloudSchool.dao.CqjStudentMapper;
import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.dao.ImgMapper;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.domain.Clazzstudent;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.statistics.ClazzBaseInfoVO;
import com.CloudSchool.service.ClazzService;
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {
	@Autowired
	ClazzMapper cm;
	@Autowired
	ClazzstudentMapper csm;
	@Autowired
	ClazzcourseteacherMapper cctm;
	@Autowired
	CqjStudentMapper sm;
	@Autowired
	CqjUserMapper um;
	@Autowired
	ImgMapper im;
	@Override
	public int CreateClass(ClazzInfo c) {
		System.out.println("开班----开始执行");
//		int jg=cm.insert(c);
//		System.out.println("开班----clazz-"+jg+"-"+c.getId()+"-"+c.getCname());
		//绑定老师
//		int jg1=csm.insertAll(c);
//		System.out.println("开班--绑定老师--clazzcourseteacher-"+jg1+"--------------------\n");
		//绑定学生
//		int jg2=cctm.insertAll(c);
//		System.out.println("开班--绑定学生--clazzstudent-"+jg2+"-----------------\n");
		//分配学生学号studentnub/职位positionid=4
		String str="-1";
		int j=0;
		for (int i = 1; i < c.getSlist().size()+1; i++) {
			if(c.getSlist().get(i-1).getStudentnub()==null||c.getSlist().get(i-1).getStudentnub()=="") {
				j++;
				if(i<10) {
					c.getSlist().get(i-1).setStudentnub(c.getCname()+"0"+j);
				}else{
					c.getSlist().get(i-1).setStudentnub(c.getCname()+j);
				}
			}
			c.getSlist().get(i-1).setPositionid(4);//设置职位编号-普通学生
			str+=","+c.getSlist().get(i-1).getStudentid();
			System.out.println("学号"+c.getSlist().get(i-1).getStudentnub()+"\n职位："+c.getSlist().get(i-1).getPositionid());
		}
		//更新学生信息-学号、职位
		int jg3=sm.setStudentnubAfterCreateClazz(c.getSlist(),str);
//		System.out.println("开班--更新学生信息-学号、职位--cqjstudent-"+jg2+"-----------------\n");
		//分配学生登录账号
//		List<CqjUser> ulist=new ArrayList<CqjUser>();
//		for (CqjStudent s : c.getSlist()) {
//			System.out.println(s.getStudentnub()+"--"+s.getStudentid());
//			CqjUser u=new CqjUser();
//			u.setUsername(s.getStudentnub());
//			u.setUsertypeid(s.getStudentid());
//			u.setUid(c.getUid());
//			ulist.add(u);
//		}
//		int jg4=um.insertAll(ulist);
//		System.out.println("开班--分配学生登录账号--cqj_user-"+jg4+"-----------------\n");
//		for (CqjUser s : ulist) {
//			System.out.println(s.getUsername()+"--"+s.getUserid());
//		}
//		int jg5=im.insertAll(ulist);
//		System.out.println("开班--分配学生登录账号用户头像--img-"+jg5+"-----------------\n");
		//新增-登录用户:账号密码都是学号usertypenub=1
		//修改-学生信息:分配学号、状态0在读/1毕业standby1、入学时间standby2
		return jg3;
	}
	/**
	 * 自动开班
	 * @return
	 */
	public int AutoCreateClass() {
		System.out.println("自动开班");
		
		return 0;
	}
	
	
	@Override
	public List<Clazz> queryListid(List<String> list) {
		// TODO Auto-generated method stub
		return cm.queryListid(list);
	}
	@Override
	public Clazz queryByid(Integer id) {
		// TODO Auto-generated method stub
		return cm.queryByid(id);
	}
	@Override
	public List<ClazzBaseInfoVO> queryClazzBaseInfo(Integer clazzId) {
		return cm.queryClazzBaseInfo(clazzId);
	}
	@Override
	public List<ClazzBaseInfoVO> queryClazzListByStaffId(Integer staffId) {
		return cm.queryClazzListByStaffId(staffId);
	}
	@Override
	public Clazz queryBanJiByUserid(Integer uid) {
		// TODO Auto-generated method stub
		return cm.queryBanJiByUserid(uid);
	}
	@Override
	public List<Clazz> queryAllBanJi() {
		// TODO Auto-generated method stub
		return cm.queryAllBanJi();
	}
}
