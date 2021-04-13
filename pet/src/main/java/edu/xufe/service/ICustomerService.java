package edu.xufe.service;

import java.util.List;

import edu.xufe.entity.Customer;

public interface ICustomerService {
	/*
	 * 添加顾客
	 * 顾肯自行注册账号
	 */
	  void save(Customer customer);
	  /*
	   * 根据账号删除顾客/注销账号
	   */
	  void delete(int number);
	  /*
	   * 修改顾客信息
	   */
	  void update(Customer customer);
	  /*
	   * 查询所有顾客
	   */
	  List<Customer> findAllCustomer();
	  /*
	   * 根据账号查询顾客
	   */
	  List<Customer> findByNumberCustomer(int number);


}
