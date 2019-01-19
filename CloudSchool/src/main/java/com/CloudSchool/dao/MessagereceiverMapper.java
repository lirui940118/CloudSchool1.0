package com.CloudSchool.dao;

import com.CloudSchool.domain.Message;
import com.CloudSchool.domain.Messagereceiver;

public interface MessagereceiverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Messagereceiver record);

    Messagereceiver selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messagereceiver record);

    int updateByPrimaryKey(Messagereceiver record);
}