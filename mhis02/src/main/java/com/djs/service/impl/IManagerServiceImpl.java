package com.djs.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djs.dao.IManagerDao;
import com.djs.entity.Manager;
import com.djs.service.IManagerService;
@Service
@Transactional
public class IManagerServiceImpl implements IManagerService {
	@Autowired
    private IManagerDao imd;
    public List<Manager> findAllByIdAndPassword(Integer number, String password) {
		return imd.findAllByNumberAndPassword(number, password);
	}

}
