package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Message;
@Mapper
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
    //聊天记录
	List<Message> getChatRecord(int userid, int chatid);
	//获取联系人列表
	List<CqjUser> getChatList(Integer userid);
}