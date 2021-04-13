package com.djs.interceptor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class SystemInterceptor implements HandlerInterceptor {
    //private static final Logger log= LoggerFactory.getLogger(SystemInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //Log.debug("拦截器测试>>>>>preHandle>> slf4j>>new>>>");
        System.out.println("拦截器测试>>>>>preHandle>>>>xxxxx");
        return true;
    }
}