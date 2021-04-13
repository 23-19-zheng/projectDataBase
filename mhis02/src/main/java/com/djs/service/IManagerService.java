package com.djs.service;

import java.util.List;

import com.djs.entity.Manager;

public interface IManagerService {
	List<Manager> findAllByIdAndPassword(Integer number,String password);
}
