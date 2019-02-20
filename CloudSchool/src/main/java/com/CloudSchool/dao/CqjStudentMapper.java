package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.cqjvo.StudentTestVo;

public interface CqjStudentMapper {
	//write by lirui
	//查询学员信息
	public CqjStudent queryStudentInfoBySid(Integer sId);
	
	
    int deleteByPrimaryKey(Integer studentid);

    int insert(CqjStudent record);

    int insertSelective(CqjStudent record);

    CqjStudent selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(CqjStudent record);

    int updateByPrimaryKey(CqjStudent record);
    
    //根据学员id查询学员对象
    public CqjStudent queryBysid(Integer cid);
    
    public int addStudents(List<CqjStudent> student);
    
    List<CqjStudent> queryNullParentsId();
    //分班-分配学号update职位
    int setStudentnubAfterCreateClazz(@Param("list") List<CqjStudent> list,@Param("str") String str);
    
    List<CqjStudent> queryStudetnTestByCidAndGid(@Param("cid")Integer cid,@Param("gid")Integer gid);
    
    List<StudentTestVo> queryTestByCidAndGid(@Param("cid")Integer cid,@Param("gid")Integer gid);
    
}