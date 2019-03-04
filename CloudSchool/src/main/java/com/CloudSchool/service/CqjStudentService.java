package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.StudentVO;
import com.CloudSchool.domain.Studentupgrade;
import com.CloudSchool.domain.statistics.StudentBaseInfoVO;

public interface CqjStudentService {
	//gk通过id查询所在班级所有学生
	public List<CqjStudent> queryTongXueByUserid(Integer uid);
	// 查询学员信息
	public StudentBaseInfoVO queryStudentInfoBySid(Integer sId);

	public int addStudents(List<CqjStudent> student);
	
	 List<CqjStudent> queryStudetnTestByCid(Integer cid,Integer gid);
	 
	 int addStudentUpGrade(List<Studentupgrade> Studentupgrade,Integer cid,Integer gid,Integer ngid);

	 List<CqjStudent> queryStudentJob();
	 
	 int updateStudentUpGrade(List<CqjStudent> Studentupgrade);
	//查询开班学生来源--新生、游离、升学-----tzx
	List<StudentVO> queryStudentForCreateClazz();
    //设置升学成功-升学开班完成，修改studentupgrade表status为1
    int setupgradeSuccess(int[] array);
}
