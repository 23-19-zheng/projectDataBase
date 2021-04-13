package edu.xufe.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xufe.dto.ResponseResult;
import edu.xufe.entity.Customer;
import edu.xufe.entity.Manager;
import edu.xufe.service.impl.ICustomerServiceImpl;
import edu.xufe.service.impl.IManagerServiceImpl;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired(required=false)
	private IManagerServiceImpl imsi;
	@Autowired(required=false)
	private ICustomerServiceImpl icsi;
	
	@GetMapping("/login.action")
	public ResponseResult login(int number,String password) {
		List<Manager> ManagerList = imsi.findByNumber(number);
		List<Customer> CustomerList = icsi.findByNumberCustomer(number);
		//管理员登录
		if(ManagerList!=null) {
			return new ResponseResult(2001,"登录成功",null,LocalDateTime.now());
		}
		//顾客登录
		else if(CustomerList!=null) {
			return new ResponseResult(2002, "登录成功", null, LocalDateTime.now());
		}
		//登录失败
		else {
			return new ResponseResult(500, "登录失败", null, LocalDateTime.now());
		}
	}
	

}
