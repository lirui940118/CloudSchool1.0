package com.CloudSchool.domain;
/**
 * 用于查询开班选择学生的列表
 * @author TZX
 *
 */
public class StudentVO extends CqjStudent {
	private Integer cid;	//原班级id
	private String cname;	//原班级编号名
	private Integer tagetgId;	//升学目标年级id
	private String tagetgName;	//升学目标年级id
	private Integer gid;	//原年级id
	private String gname;	//原年级name
	private Integer mid;	//专业id
	private String mname;	//专业name
	private Integer vid;	//版本id
	private String vname;	//版本name
	private int ctype;		//0新/1游离/2升学
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getTagetgId() {
		return tagetgId;
	}
	public void setTagetgId(Integer tagetgId) {
		this.tagetgId = tagetgId;
	}
	public String getTagetgName() {
		return tagetgName;
	}
	public void setTagetgName(String tagetgName) {
		this.tagetgName = tagetgName;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	
	
}
