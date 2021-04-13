package edu.xufe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.xufe.entity.Customer;
import edu.xufe.mapper.ICustomerMapper;
import edu.xufe.service.ICustomerService;
@Transactional//事务管理
@Service
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerMapper ism;
	
	@Override
	public void save(Customer customer) {
		this.ism.add(customer);

	}
	@Override
	public void delete(int number) {
		this.ism.delete(number);

	}
	@Override
	public void update(Customer customer) {
		this.ism.update(customer);

	}
    @Transactional(propagation=Propagation.NEVER)//防止出现幻读，或者不可重复读甚至脏读
    @Override
	public List<Customer> findAllCustomer() {
    	List<Customer> list = this.ism.findAllCustomer();
		return list;
	}
    @Transactional(propagation=Propagation.NEVER)
    @Override
	public List<Customer> findByNumberCustomer(int number) {
		List<Customer> list = this.ism.findByNumberCustomer(number);
		return list;
	}

}
