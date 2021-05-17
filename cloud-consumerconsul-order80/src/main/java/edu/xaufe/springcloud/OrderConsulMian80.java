package edu.xaufe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/11/16:35
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMian80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMian80.class,args);
    }
}
