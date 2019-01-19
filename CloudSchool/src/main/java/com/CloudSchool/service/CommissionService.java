package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.Commission;

public interface CommissionService {
	public List<Commission> query(Integer id);
}
