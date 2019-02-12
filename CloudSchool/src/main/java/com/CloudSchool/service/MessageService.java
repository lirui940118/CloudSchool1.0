/**
 * 
 */
package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Message;

/**
 * @author TZX
 *
 */
public interface MessageService {
	/**
	 * 新增消息(title:如系统提示，考试提示，任务提示;content:具体详细内容;sender:系统为0-说的就是你们调用的；url:有就填，time：不填；receiver:int[],接收者*用户id*，必填，数组存储，支持多人)
	 */
	public int insert(Message m);
	public List<Message> getChatRecord(int userid,int chatid);
	public List<CqjUser> getChatList(Integer userid);
}
