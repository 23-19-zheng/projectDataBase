package edu.xaufe.springcloud;

import edu.xaufe.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/08/17:16
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient //代表是Eureka的客户端
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)  //用自己的负载均衡算法
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
