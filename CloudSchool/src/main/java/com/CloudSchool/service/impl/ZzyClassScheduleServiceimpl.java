package com.CloudSchool.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClassroomMapper;
import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.ClazzcourseteacherMapper;
import com.CloudSchool.dao.ZzyClassScheduleMapper;
import com.CloudSchool.dao.ZzyCourseEventsMapper;
import com.CloudSchool.dao.ZzyCourseMapper;
import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.domain.Classroom;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ZzyClassSchedule;
import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.service.ZzyClassScheduleService;

@Service
@Transactional
public class ZzyClassScheduleServiceimpl implements ZzyClassScheduleService{
	@Autowired
	ClazzMapper claz;
	
	@Autowired
	ZzyCourseEventsMapper cetm;
	
	@Autowired 
	ZzyGradeMapper gram;
	
	@Autowired
	ZzyCourseMapper coum;
	
	@Autowired
	ZzyClassScheduleMapper schm;
	
	@Autowired
	ClazzcourseteacherMapper setm;
	
	@Autowired
	ClassroomMapper room;
	//排课
	@Override
	public int paike(int year, int week) throws ParseException {
		//传入年和周获取某某年某周的开始时间和结束时间
		String start=getStartDayOfWeekNo(year,week);
		String end=getEndDayOfWeekNo(year,week);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //将String 转为date
        Date date1 = sdf.parse(start);
        Date date2 = sdf.parse(end);
        List<Date> result = new ArrayList<Date>();
        //通过开始时间和结束时间判断中间的所有日期
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(date1);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(date2);
        result.add(date1);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        result.add(date2);
        
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DAY_OF_MONTH, -7);//日期偏移,正数向前,负数向后!
        //上一周的开始时间
        String wstart =sdf.format(c.getTime());
        c.setTime(date2);
        c.add(Calendar.DAY_OF_MONTH, -7);//日期偏移,正数向前,负数向后!
        //上一周的结束时间
        String wend =sdf.format(c.getTime());
        System.out.println("开始时间:"+wstart+"结束时间:"+wend);
    	//查询到所有的正常状态班级
        List<Clazz> ClaList=claz.queryAll(wstart,wend);
        for (Date date : result) {
        	//当前排课的日期
        	String presentDate=sdf.format(date);
         	//查询当前排课日期以及当前班级是否安排的事件 如果无事件进行下一步筛选 有事件则跳过当前班级
        	for (Clazz clist : ClaList) {
        		//当前班级id
        		Integer clistAndid=clist.getId();
        		
        		//在定义一个为空的 老师id
        		Integer dqtid=null;
        		//先定义一个为空的课程对象
        		ZzyCourse dqcourse= new ZzyCourse();
        		//此班级在当前日期 当前区间没有定义事件 那么在判断该班级在上什么课程 以及到哪一个课时了
    			//根据班级的id  获取这个班级的年级对象 要上什么课
    			ZzyGrade grade = gram.queryBycid(clist.getId());
    			//查看这个年级是否分了专业
    			String user1=grade.getUser1();
    			//定义课程集合
    			List<ZzyCourse> Coulist= new ArrayList<ZzyCourse>();
    			//如果没分专业	
    			if(user1.equals("0")) {
    				//那么获取这个年级所有的课程
    				Coulist=coum.queryBygidTwo(grade.getGid());
    			}else {
    				//获取这个分了专业的年级的所有课程
    				Coulist=coum.queryBygidAndmid(grade.getGid(), clist.getMid());
    			}
    			//循环这个班级所有的课程对象
    			for (ZzyCourse aa : Coulist) {
					//查询这个班级这个课程是否已经是上完了课   没上完就排课
    				int count=schm.queryClidAndCid(clist.getId(), aa.getCid());
    				System.out.println(aa.getCourseName()+"这个课程上了"+count+"次课");
    				//如果这门课程已经上完了  那就继续循环下一个课程
    				if(aa.getPeriod()==count) {
    					continue;
    				}else {
    					dqcourse=aa; 
    					break;
    				}
				}
    			//如果循环结束后dqcourse还是为空那么代表这个班级课程以及全部排完了
    			if(dqcourse.getCid()==null) {
    				continue;
    			}
    			//查询这个课程的老师是谁
    			dqtid=setm.queryClidAndCid(clist.getId(), dqcourse.getCid());
    			System.out.println("教员id是"+dqtid);
        		//返回的数据为1代表这个班级的这个日期上午有事件那么这一天不需要排课 返回0代表这一天的上午没有事件那么进行下一层的筛选
        		Integer i=filtrateEvebts(date, 0,clist.getId());
        		System.out.println("当前日期:"+presentDate);
        		System.out.println("当前班级:"+clist.getCname());
        		System.out.println(i);
        		//查询这个班级是否已经确认过课表了 如果确认过了那么循环下一个班级
        		Integer qd =schm.queryByqd(clist.getId(),date );
        		if(qd!=0) {
        			continue;
        		}
        		if(i==null) { 
        			//老师有空吗
        			Integer youkong =schm.queryByyoukong(dqtid,date,0);
        			//如果这个老师有空那么查询这个时间以及这个区间是否有上课的教室
        			if(youkong==0) {  
						System.out.println("老师有空");
						//查询到所有上课的教室
						List<Classroom> croom=queryOccupyRoom(date,0);
						if(croom!=null && croom.size()>0) {
							//当上午上课的所有条件成立后 查询下午是否有自习教室
							//查询所有自习教室
							List<Classroom> ZiXiRoom  =queryAllZiXiRoom(date,1);
							if( ZiXiRoom!=null && ZiXiRoom.size()>0) {
								//上午上课 下午自习的条件全部满足 添加一条课表记录
								ZzyClassSchedule s1= new ZzyClassSchedule();
								ZzyClassSchedule s2= new ZzyClassSchedule(); 
								s1.setClid(clist.getId());
								s1.setRid(croom.get(0).getId());
								s1.setTid(dqtid);
								s1.setCid(dqcourse.getCid());
								s1.setTime(presentDate);
								s1.setTemporalInterva(0);
								s1.setState(0);
								insertkebiao(s1);
	
								s2.setClid(clist.getId());
								s2.setRid(ZiXiRoom.get(0).getId());
								s2.setTime(presentDate);
								s2.setTemporalInterva(1);
								s2.setState(-1);
								insertkebiao(s2); 
							}else {
								//上午条件满足 下午没有自习教室 查询下午条件
								pm(date,clistAndid,dqtid,dqcourse.getCid(),presentDate);
							}
							 
						}else {
							//上午没教室  查询下午上课 上午自习的条件
							pm(date,clistAndid,dqtid,dqcourse.getCid(),presentDate);
						}
						
        			}else {
        				//如果上午老师没有空那么查询下午的条件
        				pm(date,clistAndid,dqtid,dqcourse.getCid(),presentDate); 
        			}
        			
        		}else {
        			//再次查询这个班级下午有事件吗
        			Integer i2=filtrateEvebts(date, 1,clistAndid);
    				if(i2==null) {
    					//如果下午没有事件 那么下午休息
    					ZzyClassSchedule s1= new ZzyClassSchedule();
    					s1.setClid(clistAndid);
    					s1.setTime(presentDate);
						s1.setTemporalInterva(0);
						s1.setState(i);
						insertkebiao(s1);
						ZzyClassSchedule s2= new ZzyClassSchedule();
						s2.setClid(clistAndid);
    					s2.setTime(presentDate);
						s2.setTemporalInterva(1);
						s2.setState(-2);
						insertkebiao(s2);
    				}else {
    					//下午班级有事件  那么这个班级上午有事件 下午班级又有事件 添加一天事件课表
    					ZzyClassSchedule s1= new ZzyClassSchedule();
    					s1.setClid(clistAndid);
    					s1.setTime(presentDate);
						s1.setTemporalInterva(0);
						s1.setState(i);
						insertkebiao(s1);
						ZzyClassSchedule s2=new ZzyClassSchedule();
						s2.setClid(clistAndid);
    					s2.setTime(presentDate);
						s2.setTemporalInterva(1);
						s2.setState(i2);
						insertkebiao(s2);
    				}
        			
        		}
        		
        		
			}
        	 
		}
        
        //当所有课程添加完成后 再次循环每一个班级
        //再次定义一个时间集合
        for (Clazz clazz : ClaList) {
        	List<Date> cdate = new ArrayList<Date>();
        	cdate.addAll(result);
        	for (int j = 0; j < cdate.size(); j++) {
        		  //每个班级有一个时间周集合  打包含休息 事件的日期排除出来 
        		Integer pc=schm.querySjAndXx(sdf.format(cdate.get(j)),clazz.getId());
        		Integer pc2=schm.queryByyouyouyou(clazz.getId(), cdate.get(j));
        		//如果今天有事件或者休息将这一天排除出去
        		if(pc>0 || pc2==0) {
        			System.out.println("ddd!!!!!!!!"+cdate.get(j));
        			cdate.remove(cdate.get(j--));
        		}
			}
        	/*for (Date objdate : cdate) {
				  //每个班级有一个时间周集合  打包含休息 事件的日期排除出来 
        		Integer pc=schm.querySjAndXx(sdf.format(objdate),clazz.getId());
        		//如果今天有事件或者休息将这一天排除出去
        		if(pc>0) {
        			cdate.remove(objdate);
        		}
        		
			}*/
        	//循环结束后看还有多少天是上课的天数
        	Integer size=cdate.size();
        	System.out.println(size+"次");
        	if(size==6){
        		//如果这个班级的这个礼拜六天都满足上课条件 
        		//先查询这个班级是否是课程全部排完了  如果是课程全部排完了  排了六天 那么不做处理 直接上六天课  上完GG
        		//先定义一个为空的课程对象
        		ZzyCourse dqcourse= new ZzyCourse();
        		//此班级在当前日期 当前区间没有定义事件 那么在判断该班级在上什么课程 以及到哪一个课时了
    			//根据班级的id  获取这个班级的年级对象 要上什么课
    			ZzyGrade grade = gram.queryBycid(clazz.getId());
    			//查看这个年级是否分了专业
    			String user1=grade.getUser1();
    			//定义课程集合
    			List<ZzyCourse> Coulist= new ArrayList<ZzyCourse>();
    			//如果没分专业	
    			if(user1.equals("0")) {
    				//那么获取这个年级所有的课程
    				Coulist=coum.queryBygidTwo(grade.getGid());
    			}else {
    				//获取这个分了专业的年级的所有课程
    				Coulist=coum.queryBygidAndmid(grade.getGid(), clazz.getMid());
    			}
    			//循环这个班级所有的课程对象
    			for (ZzyCourse aa : Coulist) {
					//查询这个班级这个课程是否已经是上完了课   没上完就排课
    				int count=schm.queryClidAndCid(clazz.getId(), aa.getCid());
    				System.out.println(aa.getCourseName()+"这个课程上了"+count+"次课");
    				//如果这门课程已经上完了  那就继续循环下一个课程
    				if(aa.getPeriod()==count) {
    					continue;
    				}else {
    					dqcourse=aa; 
    					break;
    				}
				}
    			//如果循环结束后dqcourse还是为空那么代表这个班级课程以及全部排完了
    			if(dqcourse.getCid()==null) {
    				
    			}else {
    			
        		//定义一个bool对象  用来记录这个班级本周是否是有两门不同的课程(就是正好一门课程课时上完切换课程)
        		Boolean sdbool=false;
        		//第一个上课的课程id
        		Integer cid=-1;
        		//记录如果有两门不同的课程 那么是从哪一天开始的
        		Integer scid=-1;
        		//循环筛选过后的时间集合
        		for (int k = 0; k < cdate.size(); k++) {
        			//通过班级id  时间   状态 查询此班级 当前时间上课的对象
        			ZzyClassSchedule  ss=schm.queryBydansk(clazz.getId(), cdate.get(k));
        			if(ss!=null) {
        				if(k==0) {
            				cid=ss.getCid();
            			}else {
             				if(cid!=ss.getCid()) {
            					sdbool=true;
            					scid=k;
            					k=cdate.size();
            				}
            			}
        			}
        			
        		}
        		//如果出现过两门不同的课程执行循环
        		List<Date> csddate = new ArrayList<Date>();
        		if(sdbool) {
        			//把不是第一种课程的日期全部加入一个新的时间集合
        			for (int l = scid; l <cdate.size() ; l++) {
    					csddate.add(cdate.get(l));
    				}
        			//既然有两门或以上的课程出现 那么判断除第一个课程外 其余课程排了多少天
        			if(csddate.size()==1) {
        				//如果是一天那么这天就休息
        				schm.update(clazz.getId(), csddate.get(0));
        			}else {
        				//如果一天以上 在这里面 随机一天休息
        				Random r=new Random();
        				int i1=r.nextInt(csddate.size());
                		schm.update(clazz.getId(), csddate.get(i1));
        			}
        		}else {
        			//代表没有出现过两门以上的课程 那么随机一天休息
        			Random r=new Random();
            		int i1=r.nextInt(5);
            		System.out.println("随机数是"+i1);
            		schm.update(clazz.getId(), cdate.get(i1));
    			}
    			}
        		
        	}else if(size==7) {
        		//如果这个班级的这个礼拜七天都满足上课条件 
        		//定义一个bool对象  用来记录这个班级本周是否是有两门不同的课程(就是正好一门课程课时上完切换课程)
        		Boolean sdbool=false;
        		//第一个上课的课程id
        		Integer cid=-1;
        		//记录如果有两门不同的课程 那么是从哪一天开始的
        		Integer scid=-1;
        		//循环筛选过后的时间集合
        		for (int k = 0; k < cdate.size(); k++) {
        			//通过班级id  时间   状态 查询此班级 当前时间上课的对象
        			ZzyClassSchedule  ss=schm.queryBydansk(clazz.getId(), cdate.get(k));
        			if(ss!=null) {
        				if(k==0) {
            				cid=ss.getCid();
            			}else {
             				if(cid!=ss.getCid()) {
            					sdbool=true;
            					scid=k;
            					k=cdate.size();
            				}
            			}
        			}
        			
        		}
        		//如果出现过两门不同的课程执行循环
        		List<Date> csddate = new ArrayList<Date>();
        		if(sdbool) {
        			//把不是第一种课程的日期全部加入一个新的时间集合
        			for (int l = scid; l <cdate.size() ; l++) {
    					csddate.add(cdate.get(l));
    				}
        			//既然有两门或以上的课程出现 那么判断除第一个课程外 其余课程排了多少天
        			if(csddate.size()==1) {
        				//如果是一天那么这天就休息 这天的前两天也休息
        				schm.update(clazz.getId(), csddate.get(0));
        				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        				Date dd = format.parse(format.format(csddate.get(0)));
        				Calendar calendar2 = Calendar.getInstance();
        				calendar2.setTime(dd);
        				calendar2.add(Calendar.DAY_OF_MONTH, -2); 
        				String T3 = format.format(calendar2.getTime() ) ;
        				Date dddd=format.parse(T3);
        				schm.update(clazz.getId(), dddd);
        			}else if(csddate.size()==2) {
        				//如果是两天那么就这两天休息
        				schm.update(clazz.getId(), csddate.get(0));
        				schm.update(clazz.getId(), csddate.get(1));
        			}else {
        				//如果两天以上 随机两天休息
        				Random r=new Random();
        				int i1=r.nextInt(csddate.size());
                		int i2=r.nextInt(csddate.size());
                		boolean xh=true;
                		while (xh) {
        					if(i1==i2) {
        						i1=r.nextInt(6)+1;
        						i2=r.nextInt(6)+1;
        					}else {
        						xh=false;
        					}
        				}
                		schm.update(clazz.getId(), csddate.get(i1));
        				schm.update(clazz.getId(), csddate.get(i2));
        			}
        		}else {
        			//代表这个班级 这个礼拜的课表没有出现两种不同的课程 那么直接随机两天休息
        			Random r=new Random();
            		int i1=r.nextInt(6)+1;
            		int i2=r.nextInt(6)+1;
            		boolean xh=true;
            		while (xh) {
    					if(i1==i2||i1+1==i2||i2+1==i1) {
    						i1=r.nextInt(6)+1;
    						i2=r.nextInt(6)+1;
    					}else {
    						xh=false;
    					}
    				}
            		System.out.println("随机数是"+i1);
            		System.out.println("随机数是"+i2);
            		schm.update(clazz.getId(), cdate.get(i1-1));
            		schm.update(clazz.getId(), cdate.get(i2-1));
        		}
        
        	}
		}
		return 1;
	}
	
	//上午条件不满足 查询下午的条件
	public Integer pm(Date date,Integer classid,Integer dqtid,Integer dqcourseid,String presentDate) {
		//没有自习教室 查询下午上课  上午自习的条件
		Integer i3=filtrateEvebts(date, 1,classid);
		if(i3==null) { 
			//老师有空吗
			Integer youkong3 =schm.queryByyoukong(dqtid,date,1);
			if(youkong3==0) {
				//查询到所有上课的教室
				List<Classroom> croom3=queryOccupyRoom(date,1);
				if(croom3.size()>0 && croom3!=null ) {
					//当上午上课的所有条件成立后 查询下午是否有自习教室
					//查询所有自习教室
					List<Classroom> ZiXiRoom3  =queryAllZiXiRoom(date,0);
					if(ZiXiRoom3.size()>0 && ZiXiRoom3!=null) {
						//下午上课 上午自习的条件全部满足 添加一条课表记录 
						ZzyClassSchedule s1= new ZzyClassSchedule();
						ZzyClassSchedule s2=new ZzyClassSchedule();
						System.out.println(classid);
						s1.setClid(classid);
						s1.setRid(ZiXiRoom3.get(0).getId());
						s1.setTime(presentDate);
						s1.setTemporalInterva(0);
						s1.setState(-1);
						insertkebiao(s1); 
						
						s2.setClid(classid);
						s2.setRid(croom3.get(0).getId());
						s2.setTid(dqtid);
						s2.setCid(dqcourseid);
						s2.setTime(presentDate);
						s2.setTemporalInterva(1);
						s2.setState(0);
						insertkebiao(s2);
					}else {
						//上午条件不满足  上午又没自习教室  那么添加一条放假课表
						ZzyClassSchedule s1=new ZzyClassSchedule();
						ZzyClassSchedule s2=new ZzyClassSchedule();
						s1.setClid(classid);
						s1.setTime(presentDate);
						s1.setTemporalInterva(0);
						s1.setState(-2);
						insertkebiao(s1);
						
						
						s2.setClid(classid);
						s2.setTime(presentDate);
						s2.setTemporalInterva(1);
						s2.setState(-2);
						insertkebiao(s2);
					}
				}else {
					//上午条件不满足  下午又没上课教室  那么添加一条放假课表
					ZzyClassSchedule s1= new ZzyClassSchedule();
					ZzyClassSchedule s2=new ZzyClassSchedule();
					s1.setClid(classid);
					s1.setTime(presentDate);
					s1.setTemporalInterva(0);
					s1.setState(-2);
					insertkebiao(s1);
					
					
					s2.setClid(classid);
					s2.setTime(presentDate);
					s2.setTemporalInterva(1);
					s2.setState(-2);
					insertkebiao(s2);
				}
			}else {
				//上午条件不满足  下午老师没时间  那么添加一条放假课表
				ZzyClassSchedule s1= new ZzyClassSchedule();
				ZzyClassSchedule s2=new ZzyClassSchedule();
				s1.setClid(classid);
				s1.setTime(presentDate);
				s1.setTemporalInterva(0);
				s1.setState(-2);
				insertkebiao(s1);
				
				
				s2.setClid(classid);
				s2.setTime(presentDate);
				s2.setTemporalInterva(1);
				s2.setState(-2);
				insertkebiao(s2);
			}
		}else {
			//上午条件不满足  下午又有事件 那么添加一条放假课表
			ZzyClassSchedule s1= new ZzyClassSchedule();
			ZzyClassSchedule s2=new ZzyClassSchedule();
			s1.setClid(classid);
			s1.setTime(presentDate);
			s1.setTemporalInterva(0);
			s1.setState(-2);
			insertkebiao(s1);
			
			
			s2.setClid(classid);
			s2.setTime(presentDate);
			s2.setTemporalInterva(1);
			s2.setState(i3);
			insertkebiao(s2);
		}
		
		return 1;
	}
	
	//查询到当前日期 当前时间区间 可以用的上课教室
	public List<Classroom> queryOccupyRoom(Date date,Integer qj){
		//查询到所有上课的教室
		List<Classroom> croom=room.queryAllRoom();
		List<Classroom> zz=new ArrayList<Classroom>();
		//排除出当前日期 当前区间已经被占用的教室 
		for (Classroom roomlist : croom) {
			Integer roombool=room.queryOccupyRoom(roomlist.getId(),date,qj); 
			//如果当前教室已经被占用那么从教室集合中移除该教室
			if(roombool==0) {
				System.out.println(roomlist.getName()+"该教室已经占用了");
				//croom.remove(roomlist);
				zz.add(roomlist);
			}
		}
		return zz;
	}
	
	//查询到当前日期 当前时间区间 可以用的自习教室
	public List<Classroom> queryAllZiXiRoom(Date date,Integer qj){
		List<Classroom> Ziroom=room.queryAllZiXiRoom();
		List<Classroom> zz=new ArrayList<Classroom>();
		for (Classroom roomZilist : Ziroom) {
			Integer roombool=room.queryOccupyRoom(roomZilist.getId(),date,qj); 
			//如果当前教室已经被占用那么从教室集合中移除该教室
			if(roombool==0) {
				System.out.println(roomZilist.getName()+"该教室已经占用了");
				zz.add(roomZilist);
				}
		}
		return zz;
	}
	
	
	
	
	//查询当前日期 当前时间区间 当前班级 是否有事件
	public Integer filtrateEvebts(Date date,Integer qj, Integer id){
		return  cetm.filtrateEvebts(date,qj,id);
	}
	
	 public String getStartDayOfWeekNo(int year,int weekNo){
         Calendar cal = getCalendarFormYear(year);
         cal.set(Calendar.WEEK_OF_YEAR, weekNo);
         return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);    
         
     }
	 private Calendar getCalendarFormYear(int year){
         Calendar cal = Calendar.getInstance();
         cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);      
         cal.set(Calendar.YEAR, year);
         return cal;
     }
	 public String getEndDayOfWeekNo(int year,int weekNo){
         Calendar cal = getCalendarFormYear(year);
         cal.set(Calendar.WEEK_OF_YEAR, weekNo);
         cal.add(Calendar.DAY_OF_WEEK, 6);
         return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);    
     }
	 
	 

	//实时课堂
	 @Override
	 public ZzyClassSchedule queryBytidAndtime(Integer tid) {
		 	//定义一个课表对象
		 	ZzyClassSchedule scheduleO = new ZzyClassSchedule();
		 	//获取当前日期
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
			
			SimpleDateFormat ssdd = new SimpleDateFormat("yyyy-MM-dd");
			String time2=sdf.format(date);
			String time3=ssdd.format(date);
			GregorianCalendar ca = new GregorianCalendar(); 
			
			//根据时间判断是上午还是下午
			if (ca.get(GregorianCalendar.AM_PM) == 0) {
				//如果是上午查询该老师在该日期该上午上课的信息
				scheduleO=schm.queryByOneY(tid, time3, 0); 
				System.out.println(tid+" "+time3+" "+0);
			} else {
				//如果是下午查询该老师在该日期该下午上课的信息
				scheduleO=schm.queryByOneY(tid, time3, 1);
				System.out.println(tid+" "+time3+" "+1);
			}
			return scheduleO;

	 }

	@Override
	public Integer insertkebiao(ZzyClassSchedule ins) {
		// TODO Auto-generated method stub
		return schm.insertkebiao(ins);
	}

	@Override
	public List<Clazz> queryKbBytime(int year,int wekk) throws ParseException {
		// TODO Auto-generated method stub
		//传入年和周获取某某年某周的开始时间和结束时间
				String start=getStartDayOfWeekNo(year,wekk);
				String end=getEndDayOfWeekNo(year,wekk);
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        //将String 转为date
		        Date date1 = sdf.parse(start);
		        Date date2 = sdf.parse(end);
		        List<Clazz> ClaList=claz.queryAllWtj(); 
		        for (Clazz clazz : ClaList) {
		        	List<ZzyClassSchedule> list=schm.queryKbBytime(date1, date2,clazz.getId());
		        	clazz.setSchlist(list);
				}
		return ClaList;
	}

	@Override
	public List<ZzyClassSchedule> gjbjqxkb(Integer cid) throws ParseException {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
	      cal.setTime(date);
	      // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	      int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	      if(1 == dayWeek){
	         cal.add(Calendar.DAY_OF_MONTH,-1);
	      }
	      // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
	      cal.setFirstDayOfWeek(Calendar.MONDAY);
	      // 获得当前日期是一个星期的第几天  
	      int day = cal.get(Calendar.DAY_OF_WEEK);
	      // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
	      cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
	      String imptimeBegin = sdf.format(cal.getTime());
	      Date imptimeBegin2 = sdf.parse(imptimeBegin);
	      System.out.println(imptimeBegin);
	      cal.add(Calendar.DATE,6);
	      String imptimeEnd = sdf.format(cal.getTime());
	      Date imptimeEnd2 = sdf.parse(imptimeEnd);
	      System.out.println(imptimeEnd);
	      List<ZzyClassSchedule> list=schm.queryKbBytimeqd(imptimeBegin2, imptimeEnd2,cid);
		return list;
	}
	
	public List<ZzyClassSchedule> anzhouckb(int year,int wekk,Integer cid) throws ParseException{
		String start=getStartDayOfWeekNo(year,wekk);
		String end=getEndDayOfWeekNo(year,wekk);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //将String 转为date
        Date date1 = sdf.parse(start);
        Date date2 = sdf.parse(end);
    	List<ZzyClassSchedule> list=schm.queryKbBytimeqd(date1, date2,cid);
    	return list;
	}
	
	@Override
	public Integer queryShengxue(Integer cid) throws ParseException  {
			//先定义一个为空的课程对象
				ZzyCourse dqcourse= new ZzyCourse();
				//根据班级的id  获取这个班级的年级对象 要上什么课
				ZzyGrade grade = gram.queryBycid(cid);
				Clazz cl = claz.queryByid(cid);
				//查看这个年级是否分了专业
				String user1=grade.getUser1();
				//定义课程集合
				List<ZzyCourse> Coulist= new ArrayList<ZzyCourse>();
				//如果没分专业	
				if(user1.equals("0")) {
					//那么获取这个年级所有的课程
					Coulist=coum.queryBygidTwo(grade.getGid());
				}else {
					//获取这个分了专业的年级的所有课程
					Coulist=coum.queryBygidAndmid(grade.getGid(), cl.getMid());
				}
				//循环这个班级所有的课程对象
				for (ZzyCourse aa : Coulist) {
					//查询这个班级这个课程是否已经是上完了课   没上完就排课
					int count=schm.queryClidAndCid(cid, aa.getCid());
					System.out.println(aa.getCourseName()+"这个课程上了"+count+"次课");
					//如果这门课程已经上完了  那就继续循环下一个课程
					if(aa.getPeriod()==count) {
						continue;
					}else {
						dqcourse=aa; 
						break;
					}
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//如果循环结束后dqcourse还是为空那么代表这个班级课程以及全部排完了
				if(dqcourse.getCid()==null) {
					//如果课程全部排完了  那么查询这个班级最后一天上课是什么时间
					List<ZzyClassSchedule>  lists=schm.queryBycidH(cid);
					//课程全部排完  最大的一天时间
					String time=lists.get(0).getTime();
					//当前时间
					Date sdate = new Date();
					//如果课程最大的一天时间早于当前时间  那么说明所有的课程全部上完了 返回1
					if(sdf.parse(time).before(sdate)) {
						return 1;
					}else{
						//如果不早于那么返回-1
						return -1;
					}
					
				}else {
					//课程没有全部排完 那么直接返回-1
					return -1;
				}
			
	}

	@Override
	public Integer updateuser1() {
		// TODO Auto-generated method stub
		return schm.updateuser1();
	}

	@Override
	public Integer deleteByuser1() {
		// TODO Auto-generated method stub
		return schm.deleteByuser1();
	}
}
