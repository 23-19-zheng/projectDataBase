package edu.xaufe.springcloud.service.impl;

import edu.xaufe.springcloud.entities.Payment;
import edu.xaufe.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.xaufe.springcloud.dao.PaymentDao;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/07/23:11
 * @Description:
 */
@Transactional  //事务
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    public PaymentDao pdao;

    @Override
    public int save(Payment payment) {
        return pdao.save(payment);
    }

    @Override
    public Payment findById(Long id) {
        return pdao.findById(id);
    }
}
