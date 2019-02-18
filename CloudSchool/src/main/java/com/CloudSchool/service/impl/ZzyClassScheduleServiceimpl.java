package com.CloudSchool.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        
        for (Date date : result) {
        	//当前排课的日期
        	String presentDate=sdf.format(date);
        	//查询到所有的正常状态班级
        	List<Clazz> ClaList=claz.queryAll();
        	//查询当前排课日期以及当前班级是否安排的事件 如果无事件进行下一步筛选 有事件则跳过当前班级
        	for (Clazz clist : ClaList) {
        		//当前班级id
        		Integer clistAndid=clist.getId();
        		//先定义一个为空的课程对象
        		ZzyCourse dqcourse= new ZzyCourse();
        		//在定义一个为空的 老师id
        		Integer dqtid=null;
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
    			if(dqcourse==null) {
    				continue;
    			}
    			//查询这个课程的老师是谁
    			dqtid=setm.queryClidAndCid(clist.getId(), dqcourse.getCid());
        		//返回的数据为1代表这个班级的这个日期上午有事件那么这一天不需要排课 返回0代表这一天的上午没有事件那么进行下一层的筛选
        		Integer i=filtrateEvebts(date, 0,clist.getId());
        		System.out.println("当前日期:"+presentDate);
        		System.out.println("当前班级:"+clist.getCname());
        		System.out.println(i);
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
        			Integer i2=filtrateEvebts(date, 0,clistAndid);
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
				if(croom3.size()>0) {
					//当上午上课的所有条件成立后 查询下午是否有自习教室
					//查询所有自习教室
					List<Classroom> ZiXiRoom3  =queryAllZiXiRoom(date,0);
					if(ZiXiRoom3.size()>0) {
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
		//排除出当前日期 当前区间已经被占用的教室 
		for (Classroom roomlist : croom) {
			Integer roombool=room.queryOccupyRoom(roomlist.getCtid(),date,qj); 
			//如果当前教室已经被占用那么从教室集合中移除该教室
			if(roombool==1) {
				croom.remove(roomlist);
			}else {
			}
		}
		return croom;
	}
	
	//查询到当前日期 当前时间区间 可以用的自习教室
	public List<Classroom> queryAllZiXiRoom(Date date,Integer qj){
		List<Classroom> Ziroom=room.queryAllZiXiRoom();
		for (Classroom roomZilist : Ziroom) {
			Integer roombool=room.queryOccupyRoom(roomZilist.getCtid(),date,qj); 
			//如果当前教室已经被占用那么从教室集合中移除该教室
			if(roombool==1) {
				System.out.println(roomZilist.getCtname()+"该教室已经占用了");
				Ziroom.remove(roomZilist);
				}
		}
		return Ziroom;
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
}
