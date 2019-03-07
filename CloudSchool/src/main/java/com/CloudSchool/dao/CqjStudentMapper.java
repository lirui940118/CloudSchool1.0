package com.CloudSchool.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.StudentVO;
import com.CloudSchool.domain.cqjvo.StudentTestVo;
import com.CloudSchool.domain.statistics.StudentBaseInfoVO;

public interface CqjStudentMapper {
	
	//gk通过学生id查询所在班级所有学生
	public List<CqjStudent> queryTongXueByUserid(Integer uid);
	//write by lirui
	//查询学员信息
	public StudentBaseInfoVO queryStudentInfoBySid(Integer sId);
	
	
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
    
    //查看未就业的毕业生
    List<CqjStudent> queryStudentJob();
    
    //查询开班学生来源--新生、游离、升学-----tzx
    List<StudentVO> queryStudentForCreateClazz();
    //设置升学成功-升学开班完成，修改studentupgrade表status为1
    int setupgradeSuccess(int[] array);
    
    public Integer updateBystudentid(CqjStudent student);
}