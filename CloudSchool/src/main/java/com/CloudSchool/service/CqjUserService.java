package com.CloudSchool.service;

import com.CloudSchool.domain.CqjUser;

public interface CqjUserService {
    CqjUser login(String username,String password);
}
