package edu.xufe.mapper;

import java.util.List;

import edu.xufe.entity.Customer;

public interface ICustomerMapper {
	/*
	 * 添加顾客
	 * 顾客自行注册账号
	 */
	  void add(Customer customer);
	  /*
	   * 根据账号删除顾客
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
