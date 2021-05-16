package edu.xaufe.springcloud.service.impl;

import edu.xaufe.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/14/19:25
 * @Description:用这中方式的优点是：1.降低业务逻辑和服务间的降级处理的代码耦合度
 *                               2.避免每个方法都要写一个降级处理的兜底方法，造成的代码膨胀
 */
@Component
public class OrderFallbackService implements OrderHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "OrderFallbackService_paymentInfo_OK，服务降级处理";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "OrderFallbackService_paymentInfo_Timeout，服务降级处理";
    }
}
