package com.CloudSchool.service;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.CqjPosition;
import com.CloudSchool.domain.CqjStudent;
import com.CloudSchool.domain.GkKaoqin;
import com.CloudSchool.domain.GkPageBean;

public interface GkKaoQinService {
	//通过用户id查询自己所有考勤
	GkPageBean<GkKaoqin> queryKaoQinByUserid(GkKaoqin kq);
	//查询班级考勤
	GkPageBean<GkKaoqin> queryAllKaoQinBanJi(GkKaoqin kq);
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
	
	
	
	//查询所有员工考勤信息
	GkPageBean<GkKaoqin> queryAllKaoQinYuanGong(GkKaoqin kq);
	
	/*学员考勤到勤率*/
    Double querykaoqinRateBygIdAndsId(Integer sId,Integer gId);
    /*员工考勤道勤率*/
    Double querykaoqinRateByStaffId(Integer staffId);
}
