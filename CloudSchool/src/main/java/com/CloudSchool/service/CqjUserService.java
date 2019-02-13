package com.CloudSchool.service;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.PageBean;

public interface CqjUserService {
    CqjUser login(String username,String password);
    CqjUser queryByUserid(Integer userid);
    PageBean pageUser(String filtrate,Integer cur,Integer pageSize);
    int updateUser(CqjUser user);
}
