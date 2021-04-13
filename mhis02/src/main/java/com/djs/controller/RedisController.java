package com.djs.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.djs.json.HttpResp;
import com.djs.service.ICitizenService;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api")
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private ICitizenService ics;

    @GetMapping("/redis")
    public HttpResp redis(){
        //把数据库的数据放入到Redis中去
        redisTemplate.opsForList().leftPush("allCitizen",ics.findByPage(1, 5));
        //从Redis中取出来
        //log.debug(redisTemplate.opsForList().range("testRedis",0,-1).toString());
        return new HttpResp(20005,"成功",null,LocalDateTime.now());
    }
}
