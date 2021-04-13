package com.djs.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.Citizen;
import com.djs.entity.Manager;
import com.djs.entity.Staff;
import com.djs.json.HttpResp;
import com.djs.service.impl.ICitizenServiceImpl;
import com.djs.service.impl.IManagerServiceImpl;
import com.djs.service.impl.IStaffServiceImpl;
@RestController
@RequestMapping("/api")
public class ManagerController {
	@Autowired
	private IManagerServiceImpl imsi;
	@Autowired
	private ICitizenServiceImpl icsi;
	@Autowired
	private IStaffServiceImpl  issi;
	
	@GetMapping("login.action")	
	public HttpResp findManager (Integer number,String password) {
		System.out.println("账号:"+number);
		System.out.println("密码:"+password);
		//管理员验证登录
		List<Manager> list01 = imsi.findAllByIdAndPassword(number, password);
		//医护人员验证登录
		List<Staff> list02 = issi.findByNumberAndPassword(number,password);
		//公民验证号登录
		List<Citizen> list03 = icsi.findByNumberAndPassword(number, password);
		
		System.out.println("管理员："+list01);
		System.out.println("医护人员："+list02);
		System.out.println("公民:"+ list03);
		if(!list01.isEmpty()) {
			//管理员
			return new HttpResp(2001, "管理员登录成功", null, LocalDateTime.now());
		}
		
		else if(!list02.isEmpty()) {
			//医护人员
			return new HttpResp(2002, "医护人员登录成功", null, LocalDateTime.now());
		}
		else if(!list03.isEmpty()) {
			//公民
			return new HttpResp(2003, "公民登录成功", null, LocalDateTime.now());
		}
		else {
			return new HttpResp(500, "登录失败", null, LocalDateTime.now());
		}
			
	
		
	}
	

}
