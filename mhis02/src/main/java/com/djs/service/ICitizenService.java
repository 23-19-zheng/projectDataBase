package com.djs.service;

import java.util.List;

import com.djs.entity.Citizen;
import com.github.pagehelper.Page;

public interface ICitizenService {
	/*
	 * 增加公民【公民注册】
	 */
	void add(Citizen c);
	/*
	 * 查询信息
	 */
	List<Citizen> findByNumberAndPassword(Integer number,String password);
	/*
	 * 分页查询
	 */
	Page<Citizen> findByPage(int currentPage,int pageSize);

}
