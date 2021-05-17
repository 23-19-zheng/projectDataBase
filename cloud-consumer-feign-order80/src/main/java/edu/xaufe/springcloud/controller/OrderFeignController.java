package edu.xaufe.springcloud.controller;

import edu.xaufe.springcloud.entities.HttpResp;
import edu.xaufe.springcloud.entities.Payment;
import edu.xaufe.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/12/15:02
 * @Description:
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public HttpResp<Payment> findById( @PathVariable("id") Long id){
        return paymentFeignService.findById(id);
    }
    @GetMapping(value = "/consumer/payment/timeout")
    public String paymentOpenfeignTimeout(){
        return paymentFeignService.paymentOpenfeignTimeout();
    }
}
