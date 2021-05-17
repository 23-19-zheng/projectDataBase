package edu.xaufe.springcloud.controller;

import com.mysql.jdbc.TimeUtil;
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
import java.util.concurrent.TimeUnit;

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
    @Value("${server.port}") //取得当前子模块的端口号
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;  //服务发现
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
            return new HttpResp(200,"插入成功,serverPort："+serverPort,result );
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
        //获得所有的微服务实例
        List<String> services = discoveryClient.getServices(); //ctrl + alt + v 自动生成返回类型
        for(String element:services){
            log.info("******** element:"+element);
        }
        //获得当前（具体）实例下面的所有微服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance serviceInstance:instances){
            log.info(serviceInstance.getInstanceId()+"\t"
                    +serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"
                    +serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping(value = "/timeout")
    public String paymentOpenfeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
