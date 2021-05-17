package edu.xaufe.springcloud.controller;

import edu.xaufe.springcloud.entities.HttpResp;
import edu.xaufe.springcloud.entities.Payment;
import edu.xaufe.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/07/23:16
 * @Description:
 */
@RequestMapping("/payment")
@RestController //相当于@Controller+@ResponseBody
@Slf4j  //日志
public class PaymentController {
    @Resource
    private PaymentService ps;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;
    /*
    Resultful风格:
    @PostMapping——添加
    @GetMapping——查询
    @PutMapping——修改
    @DeleteMapping——删除
     */
    @PostMapping( "/create")
    public HttpResp add(@RequestBody Payment payment){
        int result = ps.save(payment);
        log.info("*********查询结果" + result);
        if(result > 0){
            return new HttpResp(200,"插入成功,serverPort："+serverPort,result);
        }else{
            return new HttpResp(444,"插入失败",null);
        }
    }
    @GetMapping( "/findById/{id}")
    public HttpResp<Payment> findById( @PathVariable ("id") Long id){
        Payment payment = ps.findById(id);
        log.info("***********查询结果" + payment );
        if(payment != null){
            return new HttpResp(200,"查询成功，serverPort："+serverPort,payment);
        }else{
            return new HttpResp(444,"id为" + id + "查询的支付流水号不存在",null);
        }
    }
    @GetMapping("/discover")
    public Object discover(){
        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("当前eureka下面含有的所有微服务实例名称" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance service : instances){
            log.info(service.getInstanceId()+
                    "\t"+service.getHost()+"\t"+service.getPort()+"\t"+service.getUri()+"\t"
                    +service.getServiceId()+"\t"+service.getScheme()+"\t"+service.getMetadata());
        }
        return this.discoveryClient;
    }
    @GetMapping("/lb")
    public  String getPaymentLb(){
        return serverPort;
    }
}
