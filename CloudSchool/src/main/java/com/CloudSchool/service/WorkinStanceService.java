package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.zjfvo.PublishWorkInfo;
import com.CloudSchool.domain.zjfvo.WorkPublishParam;

public interface WorkinStanceService {
	/*作业发布*/
	public int publishWork(WorkPublishParam obj);
	
	 /*根据教师id查询发布的作业 */
    PageBean queryPublishWorkByTid(Integer tid,Integer wStatus,Integer pageSize,Integer cur);
    
    /**
     * 根据学生id和作业id查询作业详情
   * @param wid 作业id
   * @param sid	学生id
   * @return
   */
    Workinstance queryStudentWork(Integer wid,Integer sid);
}
