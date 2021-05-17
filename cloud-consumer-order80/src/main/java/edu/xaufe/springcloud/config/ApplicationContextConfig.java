package edu.xaufe.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/08/17:22
 * @Description:在容器中注入RestTemplate对象
 */
@Configuration
public class ApplicationContextConfig {
    @Bean //向容器注入RestTemplate对象
    //@LoadBalanced //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
