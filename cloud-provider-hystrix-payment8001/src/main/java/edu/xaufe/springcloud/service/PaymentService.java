package edu.xaufe.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/14/9:31
 * @Description:
 */
@Service
public class PaymentService {
    //访问成功
    public String payemntInfo_OK(Integer id){
        return "线程池"+Thread.currentThread().getName()+"  paymentInfo_OK,id" + id + "\t"+"哈哈哈";
    }
    //访问超时
    /*
    服务降级熔断，当下面这个方法出现异常或者是超过设置的响应时间，那个就会执行降级后的方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")})  //单位毫秒
    public String paymentInfo_Timeout(Integer id){
        //int n = 10 / 0;

        int num = 1000;
        try{
            TimeUnit.MILLISECONDS.sleep(num);//单位毫秒
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "线程池"+Thread.currentThread().getName()+"  PaymentInfo_Timeout,id"+id+"\t"+"超时";
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"系统繁忙，运行时异常";
    }
    /*
    服务降级熔断
     */
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //在这个滚动时间窗口期内（默认10秒）当请求次数大于10就开启段断路器，但是如果没有超过10次，就算全部请求都错误也不开启
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),  //睡眠时间窗口期，表示在断路器开启的5秒后，断路器进入到半开状态，服务降级处理，当有其他的请求来的时候，进行判断请求合法性或者请求是否超时等，尝试进入到关闭状态
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //在超过请求的最大次数后，如果请求的失败率达到60（默认50%）后跳闸，断路器打开，服务熔断；
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
