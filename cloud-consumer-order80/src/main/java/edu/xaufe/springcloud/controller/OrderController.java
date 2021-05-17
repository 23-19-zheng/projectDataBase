package edu.xaufe.springcloud.controller;

import edu.xaufe.springcloud.entities.HttpResp;
import edu.xaufe.springcloud.entities.Payment;
import edu.xaufe.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/08/17:27
 * @Description:
 */
@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public HttpResp<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment, HttpResp.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public HttpResp<Payment> getPayment(@PathVariable ("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/findById/" + id,HttpResp.class);
    }
    @GetMapping("/consumer/payment/getEntity/{id}")
    public HttpResp<Payment> getEntityPayment(@PathVariable ("id") Long id){
        ResponseEntity<HttpResp> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/findById/" + id, HttpResp.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();//返回请求体
        }else{
            return new HttpResp(444,"操作失败");
        }
    }
    @GetMapping(value = "consumer/payment/lb")
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }
}
