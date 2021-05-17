package edu.xaufe.springcloud.service;

import edu.xaufe.springcloud.entities.HttpResp;
import edu.xaufe.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/12/14:58
 * @Description:使用openfeign 可以更符合平时的开发习惯，面向接口的开发，
 *              这个接口的方法与绑定的实例服务机器下的所提供的服务一意对应
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE") //调用CLOUD-PAYMENT-SERVICE实例名称下面的那台机器提供服务
public interface PaymentFeignService {
    /**
     *根据对应的访问路径访问方法，可看做是方法的映射，只不过是中间加了一层
     */
    @PostMapping( "/payment/create")
    HttpResp add(@RequestBody Payment payment);
    @GetMapping( "/payment/findById/{id}")
    HttpResp<Payment> findById( @PathVariable("id") Long id);
    @GetMapping(value = "/payment/timeout")
    public String paymentOpenfeignTimeout();
}
