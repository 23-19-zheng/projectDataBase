package edu.xufe.service;

import java.util.List;

import edu.xufe.entity.Manager;

public interface IManagerService {
	//查询管理员/商家账号
	List<Manager> findByNumber(int number);

}
