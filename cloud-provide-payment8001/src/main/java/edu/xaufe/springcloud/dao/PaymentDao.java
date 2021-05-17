package edu.xaufe.springcloud.dao;

import edu.xaufe.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/10/11:24
 * @Description:
 */
@Mapper //在与mybaits整合的时候推荐使用@Mapper(用@Repository可能会向数据库插入数据出现错误)
public interface PaymentDao {
    //增加支付订单
    int save(Payment payment);
    //查询支付订单
    Payment findById(@PathVariable("id") Long id);
}

