package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjRole;

public interface CqjRoleService {
    List<CqjRole> queryAllRole();
    int updateRoleAndModule(Integer roleid,String[] result);
    int addRole(CqjRole record,String[] arry);
}
