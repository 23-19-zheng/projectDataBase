package com.djs.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.Citizen;
import com.djs.json.HttpResp;
import com.djs.service.impl.ICitizenServiceImpl;

@RestController
public class CitizenController {
	@Autowired
	private ICitizenServiceImpl icsi;
	@Autowired
	private RedisTemplate<String,Object>  redisTemplate;
	
	/*
	 * 公民注册
	 */
	@PostMapping("CitizenLogin.action")
	public HttpResp add(@RequestBody  Citizen c) {
		System.out.println(c);
		icsi.add(c);
		return new HttpResp(200, "注册成功", null,LocalDateTime.now());
	}
	/*
	 * 公民登录【查看自己信息】
	 */
	@GetMapping("findInformations.action")
	public HttpResp find(String number,String password) {
		Integer number01 = Integer.parseInt(number);
		String password01 =password;
		List<Citizen> list = icsi.findByNumberAndPassword(number01,password01);
		System.out.println(list);
		return new HttpResp(200, "公民登录成功", list,LocalDateTime.now());
	}
	@GetMapping("findAllCitizen.ation")
	public HttpResp findAll() {
		List<Object> allCitizen = redisTemplate.opsForList().range("allCitizen",0 , -1);//读取所有的信息
		return new HttpResp(200, "公民登录成功", allCitizen,LocalDateTime.now());
	}

}
