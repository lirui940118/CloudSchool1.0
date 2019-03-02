package com.CloudSchool.service;

import java.util.List;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.statistics.GradeVO;

public interface ZzyGradeService {
	//查询该学员所读过的年级 write by lirui
	public List<ZzyGrade> queryGradeListBySid(Integer sId);
	//查询该学员当前在读年级
	public ZzyGrade queryCurrentGradeBySid(Integer sId);
	//根据版本id查询年级
	public List<ZzyGrade> queryByvid(Integer vid);
	//查询所有年级
	public List<ZzyGrade> queryAll();
	//所有年级下所有批次下的所有班级  write by lirui
	public List<GradeVO> queryAllGradePcClazz(Integer gId,String pc);
	public List<ZzyGrade> queryGradeAndClazz();
	//根据班级id查询年级
	public ZzyGrade queryBycid(Integer id);
}
