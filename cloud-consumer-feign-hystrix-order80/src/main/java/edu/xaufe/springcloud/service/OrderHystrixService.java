package edu.xaufe.springcloud.service;

import edu.xaufe.springcloud.service.impl.OrderFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/14/15:16
 * @Description:
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFallbackService.class)
/*
当服务端的服务出现宕机，超时，运行异常时，通过反射拿到OrderFallbackService.class的Class对象操作里面的方法作为服务降级处理
 */
public interface OrderHystrixService {
    @GetMapping("/payment/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/Timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
