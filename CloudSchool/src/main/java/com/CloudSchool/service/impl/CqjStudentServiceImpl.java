package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.CqjParentsMapper;
import com.CloudSchool.dao.CqjParentsStudentMapper;
import com.CloudSchool.dao.CqjStudentMapper;
import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.dao.StudentupgradeMapper;
import com.CloudSchool.domain.CqjParents;
import com.CloudSchool.domain.CqjParentsStudent;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Studentupgrade;
import com.CloudSchool.domain.cqjvo.StudentTestVo;
import com.CloudSchool.service.CqjStudentService;
@Service
@Transactional
public class CqjStudentServiceImpl implements CqjStudentService{

	@Autowired
	CqjStudentMapper cqjStudentMapper;
	@Autowired
	CqjParentsMapper cpm;
	@Autowired
	CqjParentsStudentMapper cpsm;
	@Autowired
	CqjUserMapper cum;
	@Autowired
	StudentupgradeMapper sugm;
	@Autowired
	ClazzMapper cm;
	@Override
	public CqjStudent queryStudentInfoBySid(Integer sId) {
		return cqjStudentMapper.queryStudentInfoBySid(sId);
	}
	@Override
	public int addStudents(List<CqjStudent> student) {
		// TODO Auto-generated method stub
		int i=cqjStudentMapper.addStudents(student);
		//查询没有家长关联的学生
		List<CqjStudent> list=cqjStudentMapper.queryNullParentsId();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (CqjStudent s : list) {
			if(s!=null) {
				if(s.getPhone()!=null) {
					//存在该家长手机号 通过查出的家长编号 和 学生编号 关联
					CqjParentsStudent cps=new CqjParentsStudent();
					cps.setParentsid(s.getParentsid());
					cps.setStudentid(s.getStudentid());
					//新增关联
					cpsm.insertSelective(cps);
				}else {
					if(map.containsKey(s.getStandby4())) {
						CqjParentsStudent cps=new CqjParentsStudent();
						cps.setParentsid(map.get(s.getStandby4()));
						cps.setStudentid(s.getStudentid());
						//新增关联
						cpsm.insertSelective(cps);
					}else {
						//不存在家长手机号 那么新增一条家长信息 并关联
						CqjParents p=new CqjParents();
						//找不到家长名称？
						for (CqjStudent stu : student) {
							if(stu.getStandby4().equals(s.getStandby4())) {
								p.setParentsname(stu.getParentsname());
							}
						}
						
						p.setAddress(s.getAddress());
						p.setPhone(s.getStandby4());
						//新增家长信息
						cpm.insertSelective(p);
						CqjParentsStudent cps=new CqjParentsStudent();
						cps.setParentsid(p.getParentsid());
						cps.setStudentid(s.getStudentid());
						//新增关联
						cpsm.insertSelective(cps);
						//为家长添加用户
						CqjUser user=new CqjUser();
						user.setUsername(p.getPhone());
						user.setPassword("8888");
						user.setRoleid(3);
						user.setUsertypenub(2);
						user.setUsertypeid(p.getParentsid());
						cum.insertSelective(user);
						map.put(p.getPhone(), p.getParentsid());
					}
					
				}
			}
		}
		return 0;
	}
	@Override
	public List<CqjStudent> queryStudetnTestByCid(Integer cid,Integer gid) {
		// TODO Auto-generated method stub
		List<CqjStudent> slist=cqjStudentMapper.queryStudetnTestByCidAndGid(cid,gid);
		List<StudentTestVo> stvo=cqjStudentMapper.queryTestByCidAndGid(cid,gid);
		for (CqjStudent s : slist) {
			
			if(s!=null) {
				int i=0;
				int j=0;
				for (StudentTestVo st : s.getStList()) {
					i+=st.getTestScore()/st.getTestSumScore()>0.6?0:1;
					if(st.getTc()>1) {
						j++;
					}
				}
				System.out.println(stvo.size()+","+s.getStList().size());
				if(i>0&&stvo.size()!=s.getStList().size()) {
					s.setStandby2(1+"");
				}else if(i>0){
					s.setStandby2(2+"");
				}else if(stvo.size()!=s.getStList().size()){
					s.setStandby2(3+"");
				}else {
					s.setStandby2(0+"");
				}
				if(j>0) {
					s.setStandby3(1+"");
				}else {
					s.setStandby3(0+"");
				}
				System.out.println(s.getStandby2());
			}
		}
		return slist;
	}
	@Override
	public int addStudentUpGrade(List<Studentupgrade> Studentupgrade,Integer cid) {
		// TODO Auto-generated method stub
		sugm.addStudentUpGrades(Studentupgrade);
		return cm.updateStatusByCid(-1, cid);
	}

}
