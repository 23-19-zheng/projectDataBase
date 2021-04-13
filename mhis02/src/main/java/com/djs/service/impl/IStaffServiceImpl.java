package com.djs.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djs.dao.IStaffDao;
import com.djs.entity.Staff;
import com.djs.service.IStaffService;
@Service
@Transactional
public class IStaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao isd;
	public List<Staff> findByNumberAndPassword(Integer number,String password) {
		List<Staff> list = isd.findByNumberAndPassword(number,password);
		return list;
	}

}
