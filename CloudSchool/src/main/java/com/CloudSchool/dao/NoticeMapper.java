package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
    
    List<Notice> query();
    CqjUser querpersonerInfo(Integer uid);

	List<Notice> query(@Param("time")String time, @Param("str")String str);
	/**
	 * 获取通知目标数组，用于发送通知弹窗的所有目标，根据年级id 或班级id
	 * @param gradeid
	 * @param clazzid
	 * @return
	 */
	int[] getNoticeReceiveByGradeidOrClazzid(@Param("gradeid")Integer gradeid,@Param("clazzid")Integer clazzid);
	int[] getNoticeReceiveByRange(@Param("receiverrange")Integer receiverrange);
	//查询最新的通知（只查全部中的最新）-tzx首页显示
	Notice queryLastOneInAll();
}