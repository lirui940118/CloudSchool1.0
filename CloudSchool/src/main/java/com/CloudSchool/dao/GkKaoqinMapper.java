package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;

public interface GkKaoqinMapper {
	//通过用户id查询自己所有考勤行数
	int queryKaoQinByUseridCount(GkKaoqin kq);
	//通过用户id查询自己所有考勤
	List<GkKaoqin> queryKaoQinByUserid(GkKaoqin kq);
	//查询班级考勤
	List<GkKaoqin> queryAllKaoQinBanJi(GkKaoqin kq);
	//查询班级考勤行数
	int queryAllKaoQinBanJiCount(GkKaoqin kq);
	//查询某段时间内的考勤状况（员工）
	List<GkKaoqin> queryKaoQinYuanGongXiangByTime(@Param("userid")Integer userid,@Param("startStr")String startStr,@Param("endStr")String endStr);
	//修改班级当天考勤状态
	int updateKaoQinBanJi(@Param("kqStateId")Integer kqStateId,@Param("uid")Integer uid);
	//判断班级当天是否考勤
	GkKaoqin queryKaoQinPanDuan(Integer userid);
	//新增班级当天考勤 
	int insertBanJiKaoQin(List<GkKaoqin> list,@Param("cid")Integer cid,@Param("gid")Integer gid);
	
	//新增班级当天考勤 
	int insertYuanGongKaoQin(List<GkKaoqin> list);
	
	
	//查询所有员工考勤
	List<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq);
	//查询所有员工考勤行数
	int queryAllKaoQinYuanGongCount(GkKaoqin kq);
	
	//查询所有职位
	CqjPosition queryAllZhiWei();
				
	
    int deleteByPrimaryKey(Integer kqId);

    int insert(GkKaoqin record);

    int insertSelective(GkKaoqin record);

    GkKaoqin selectByPrimaryKey(Integer kqId);

    int updateByPrimaryKeySelective(GkKaoqin record);

    int updateByPrimaryKey(GkKaoqin record);
    
    /*学员考勤到勤率*/
    Double querykaoqinRateBygIdAndsId(@Param("sId") Integer sId,@Param("gId") Integer gId);
    /*员工考勤道勤率*/
    Double querykaoqinRateByStaffId(Integer staffId);
}