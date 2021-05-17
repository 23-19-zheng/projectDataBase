package edu.xaufe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/15/11:23
 * @Description:
 */
@SpringBootApplication
@EnableHystrixDashboard  //开启服务实时监控
public class HystrixDashboradMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboradMain9001.class,args);
    }
}
