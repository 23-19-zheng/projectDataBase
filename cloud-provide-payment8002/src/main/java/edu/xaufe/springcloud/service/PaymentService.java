package edu.xaufe.springcloud.service;
import edu.xaufe.springcloud.entities.Payment;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/07/23:11
 * @Description:
 */
public interface PaymentService {
    int save(Payment payment);
    Payment findById(Long id);
}
