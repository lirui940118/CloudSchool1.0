package com.CloudSchool.service.impl;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClassroomMapper;
import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.ClazzcourseteacherMapper;
import com.CloudSchool.dao.ClazzstudentMapper;
import com.CloudSchool.dao.CqjStudentMapper;
import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.dao.ImgMapper;
import com.CloudSchool.dao.StudentupgradeMapper;
import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.domain.Classroom;
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
	@Autowired
	ClassroomMapper classroomMapper;
	@Autowired
	ZzyGradeMapper gm;
	@Autowired
	StudentupgradeMapper stupMapper;
	@Override
	public int CreateClass(ClazzInfo c) {
		System.out.println("开班----开始执行");
		int isFirstGrade=gm.isFirstGrade(c.getGid());
		if(1==isFirstGrade) {
			System.out.println("新生班级");
		}else {
			System.out.println("升学班级");
		}
		c.setStatus(1);
		c.setCname(getClazzName(0, null));
		c.setPc(getClazzPC(c.getGid()));
		int jg=cm.insert(c);
		System.out.println("开班----clazz-"+jg+"-"+c.getId()+"-"+c.getCname());
		//绑定老师
		int jg1=csm.insertAll(c);
		System.out.println("开班--绑定老师--clazzcourseteacher-"+jg1+"--------------------\n");
		//绑定学生
		int jg2=cctm.insertAll(c);
		System.out.println("开班--绑定学生--clazzstudent-"+jg2+"-----------------\n");
		//分配学生学号studentnub/职位positionid=4
		List<Integer> existUserList=null;	//已有学号、用户账号的学生
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
			}else {
				existUserList.add(i-1);
			}
			c.getSlist().get(i-1).setPositionid(4);//设置职位编号-普通学生
			str+=","+c.getSlist().get(i-1).getStudentid();
			System.out.println("学号"+c.getSlist().get(i-1).getStudentnub()+"\n职位："+c.getSlist().get(i-1).getPositionid());
		}
		//更新学生信息-学号、职位:分配学号、状态0在读/1毕业standby1、入学时间standby2
		int jg3=sm.setStudentnubAfterCreateClazz(c.getSlist(),str);
		System.out.println("开班--更新学生信息-学号、职位--cqjstudent-"+jg3+"-----------------\n");
		//分配学生登录账号:账号密码都是学号usertypenub=1
		List<CqjUser> ulist=new ArrayList<CqjUser>();
		for (CqjStudent s : c.getSlist()) {
			//排除已分配登录用户账号的学生
			if(null!=s.getStudentnub()&&""!=s.getStudentnub()) {
				System.out.println(s.getStudentnub()+"--"+s.getStudentid());
				CqjUser u=new CqjUser();
				u.setUsername(s.getStudentnub());
				u.setUsertypeid(s.getStudentid());
				u.setUid(c.getUid());
				ulist.add(u);
			}
		}
		int jg4=um.insertAll(ulist);
		System.out.println("开班--分配学生登录账号--cqj_user-"+jg4+"-----------------\n");
		for (CqjUser s : ulist) {
			System.out.println(s.getUsername()+"--"+s.getUserid());
		}
		int jg5=im.insertAll(ulist);
		System.out.println("开班--分配学生登录账号用户头像--img-"+jg5+"-----------------\n");
		//将游离改为游离已分配
		int jg6=csm.setStudentStatusAfterCreateClazz(c.getSlist());
		System.out.println("开班--将游离3改为游离已分配4--clazzstuednt-"+jg6+"-----------------\n");
		if(0==isFirstGrade) {
			//改升学状态为1
			int jg7= stupMapper.setStatusAfterCreateClazz(c.getSlist());
			System.out.println("开班--改升学状态为1--studentupgrade-"+jg7+"-----------------\n");
		}
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
	public List<Clazz> queryByClazzidAllStu(Integer[] clazzs) {
		// TODO Auto-generated method stub
		return cm.queryByClazzidAllStu(clazzs);
	}
	
	
	//根据时间段查询空教室(赵举峰)
	@Override
	public List<Classroom> queryClassRoomAll(String time,Integer status) {
		System.out.println(time);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(time);
			List<Classroom> list=classroomMapper.query();
			List<Classroom> nullroom=new ArrayList<Classroom>();	//空教室集合
			for (Classroom classroom : list) {
				//不是全天
				if(status!=2) {
					int i=classroomMapper.queryOccupyRoom(classroom.getId(), date, status);
					if(i>0) {
						System.out.println("占用");
						continue;
					}
					System.out.println("可用");
					nullroom.add(classroom);
				}else {
					//全天
					int i=classroomMapper.queryBytimeRoom(classroom.getId(), date);
					if(i>0) {
						//占用
						System.out.println("占用");
						continue;
					}
					//空教室
					nullroom.add(classroom);
				}
				
			}
			return nullroom;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public Clazz queryBanJiByUserid(Integer uid) {
		// TODO Auto-generated method stub
		return cm.queryBanJiByUserid(uid);
	}
	@Override
	public List<Clazz> queryAllBanJi() {
		// TODO Auto-generated method stub
		return cm.queryAllBanJi();
	}
	public String getClazzName(int id,int[] array) {
		//0分配开学新班名称,1分配升学后新班名称，
        Date date = new Date();
        //EE为fri/thu简称 EEEEEE为英文全名 Local.US
//        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE", Locale.CHINA);
//        System.out.println("当前时间："+df2.format(date));
//        Date date2 = df2.parse("2007-11-30 02:51:07 星期五"); //将字符转换为日期
        int y=date.getYear()+1900;
		String cname=null;
		switch (id) {
		case 0:
			System.out.println("自动创建一个新的班级名！");
			String lastcname=cm.getLastClazzName();
			System.out.println("最后的一个班级名称为：:"+lastcname);
			int num=1;
			if(null!=lastcname) {
				num=Integer.parseInt(lastcname.substring(4))+1;
			}
			if(num<10) {
				cname="AT"+(y+"").substring(2)+"0"+num;
			}else {
				cname="AT"+(y+"").substring(2)+num;
			}
			break;
		case 1:
			if(null==array) {
				break;
			}
			List<String> list=cm.getClazzNameBeforeGradeUp(array);
			if(0==list.size()) {
				System.out.println("未查询到原班级名称或已占用！");
				cname=getClazzName(0,null);
			}else {
				cname=list.get(0);
			}
			break;
		default:
			System.out.println("输入数字指令不是0/1，");
			cname=getClazzName(0,null);
			break;
		}
		System.out.println("分配的班级名称为：:"+cname);
		return cname;
	}
	@Override
	public String getClazzPC(int gid) {
		// TODO Auto-generated method stub
		Clazz c=cm.getLastClazzPC(gid);
        Date date = new Date();
        int y=date.getYear()+1900;
		String pc=null;
		if(null==c) {
			System.out.println("本年第一个批次");
			pc=""+y+"01";
		}else {
			System.out.println("年级id为："+gid+"，最后的一个班级批次为：:"+c.getPc()+",班级数："+c.getCount()+",相隔天数："+c.getNormalCount());
			//设置批次限制最多4个班或startdate为30天间隔，否则是新批次
			if(c.getCount()<4&&c.getNormalCount()<=30) {
				pc=c.getPc();
			}else {
				pc=""+(Integer.parseInt(c.getPc())+1);
			}
		}
		System.out.println("分配的批次为："+pc);
		return pc;
	}
}
