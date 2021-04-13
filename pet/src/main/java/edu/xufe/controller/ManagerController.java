package edu.xufe.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xufe.dto.ResponseResult;
import edu.xufe.entity.Customer;
import edu.xufe.service.impl.ICustomerServiceImpl;
@RestController
@RequestMapping("/api")

public class ManagerController {
	@Autowired
	private ICustomerServiceImpl icm;
	/*
	 * 顾客注册账号
	 */
	@PutMapping("/addCustomer.action")
	public ResponseResult add(Customer customer) {
		icm.save(customer);
		return new ResponseResult(200, "注册成功", null, LocalDateTime.now());
	}
	/*
	 * 注销用户
	 */
	@DeleteMapping("/deleteCustomer.action")
	public ResponseResult delete(int number){
		icm.delete(number);
		return new ResponseResult(200, "注销成功", null, LocalDateTime.now());
	}
	/*
	 * 修改顾客信息
	 */
    @PostMapping("/updateCustomer.action")
	public ResponseResult update(Customer customer) {
		icm.update(customer);
		return new ResponseResult(200, "修改成功", null, LocalDateTime.now());
	}
	/*
	 * 查找顾客
	 */
    @GetMapping("/findAllCustomer.action")
	public ResponseResult findAll(){
		List<Customer> list = icm.findAllCustomer();
		return new ResponseResult(200, "查找成功", list, LocalDateTime.now());
	}
	/*
	 * 按照账号查询
	 */
    @GetMapping("/findAllByNumberCustomer.action")
	public ResponseResult findAllByNumber(int number){
		List<Customer> list = icm.findByNumberCustomer(number);
		return new ResponseResult(200, "查找成功", list, LocalDateTime.now());
	}
	

}
