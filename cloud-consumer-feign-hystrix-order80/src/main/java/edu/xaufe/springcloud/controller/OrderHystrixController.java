package edu.xaufe.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import edu.xaufe.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/14/15:26
 * @Description:
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //全局的服务降级方法
public class OrderHystrixController {
    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
       String result = orderHystrixService.paymentInfo_OK(id);
       return result;
    }
    @GetMapping("/consumer/payment/hystrix/Timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1500")})  //客户端等待服务端的时间是1.5秒
    @HystrixCommand //不写后面的相关属性代表使用默认的全局服务降级
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
       String result = orderHystrixService.paymentInfo_Timeout(id);
       return result;
    }
    //兜底的方法
    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id){
        return "系统繁忙或运行报错";
    }
    //全局的fallback方法
    public String payment_Global_FallbackMethod(){
        return "global我是全局的服务降级处理";
    }
}
