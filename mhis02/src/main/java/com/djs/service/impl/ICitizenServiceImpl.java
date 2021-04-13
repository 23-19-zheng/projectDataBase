package com.djs.service.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.djs.dao.ICitizenDao;
import com.djs.entity.Citizen;
import com.djs.service.ICitizenService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ICitizenServiceImpl implements ICitizenService{
	@Autowired
    private ICitizenDao icd;
	private List<Citizen> list;

	public void add(Citizen c) {
		icd.save(c);
		
	}
	public List<Citizen> findByNumberAndPassword(Integer number, String password) {
        List<Citizen> list = icd.findByNumberAndPassword(number, password);
		return list;
	}
	/*
	 * currentPage 是开始分页的页码
	 * 
	 * pageSize 是每页显示的数量
	 */
	public Page<Citizen> findByPage(int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);//
		List<Citizen> list = icd.findAll();
		//把查询的结果放入到pageInfo对象中
		PageInfo<Citizen> pageInfo = new PageInfo<Citizen>(list);
		return (Page<Citizen>)pageInfo.getList();//转化为Page对象
	}

	

}
