package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.statistics.CourseVO;

@Mapper
public interface LrStaffAbilityMapper {
	//升学率 教员和班主任通用 typeId 0为教员 1为班主任
	public Double getUpRateByStaffId(@Param("staffId")Integer staffId,@Param("typeId")Integer typeId);
	//就业率  教员和班主任通用 typeId 0为教员 1为班主任
	public Double getWorkRateByStaffId(@Param("staffId")Integer staffId,@Param("typeId")Integer typeId);
	//谈心（访谈） 覆盖率（广度rate） 
	public Double getTalkRateByStaffId(Integer staffId);
	//谈心（访谈） 基本次数（深度count）
	public Double getTalkCountRateByStaffId(@Param("staffId")Integer staffId,@Param("talkStandarCount")Integer talkStandarCount);
	//平均布置作业次数 
	public Double getWorkCountReteByStaffId(@Param("staffId")Integer staffId,@Param("workStandarCount")Integer workStandarCount);
	//平均布置考试次数
	public Double getTestCountReteByStaffId(@Param("staffId")Integer staffId,@Param("testStandarCount")Integer testStandarCount);
	//学员做题数量
	public Double getStudentRealTopicCountRateByStaffId(Integer staffId);
	//学生做题正确率
	public Double getStudentRightTopicRateByStaffId(Integer staffId);
	
	
	
	//==========================开办======================
	/*选出教员*/
	public List<CourseVO> queryStaffAboutOPenStaffBygIdAndmId(@Param("gId") Integer gId,@Param("mId") Integer mId);
	/*教员某一门课程下得分 */
	public Integer getStaffScoreAboutOpenCLazzByStaffIdAndCourseId(@Param("staffId") Integer staffId,@Param("courseId") Integer courseId);
}
