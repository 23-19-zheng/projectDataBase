package edu.xufe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.xufe.entity.Manager;
import edu.xufe.mapper.IManagerMapper;
import edu.xufe.service.IManagerService;
@Transactional //事物管理
@Service
public class IManagerServiceImpl implements IManagerService {
	@Resource  //这个注解是Spring框架的【@Resource是java的】
	private IManagerMapper imm;

	@Override
	 @Transactional(propagation=Propagation.NEVER)//不需要事务
		public List<Manager> findByNumber(int number) {
			List<Manager> list = this.imm.findByNumber(number);
			return list;
		}

	
   
}
