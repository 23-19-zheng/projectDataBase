package com.djs.service;

import java.util.List;

import com.djs.entity.Staff;

public interface IStaffService {
	List<Staff> findByNumberAndPassword(Integer number,String password);

}
