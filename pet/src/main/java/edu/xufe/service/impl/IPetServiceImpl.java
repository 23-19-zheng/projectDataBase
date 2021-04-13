package edu.xufe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.xufe.entity.Pet;
import edu.xufe.mapper.IPetMapper;
import edu.xufe.service.IPetService;
@Transactional
@Service
public class IPetServiceImpl implements IPetService {
	@Autowired
	private IPetMapper ipm;
	@Override
	public void save(Pet pet) {
		this.ipm.add(pet);
		
	}
	@Override
	public void delete(int number) {
		this.ipm.delete(number);
		
	}
	@Override
	public void update(Pet pet) {
		this.ipm.update(pet);
		
	}
    @Transactional(propagation=Propagation.NEVER)
    @Override
	public List<Pet> findPetByNumber(int number) {
		List<Pet> list = this.ipm.findPetByNumber(number);
		return list;
	}
    @Transactional(propagation=Propagation.NEVER)
    @Override
	public List<Pet> findPetByName(String name) {
		List<Pet> list = this.ipm.findPetByName(name);
		return list;
	}
    @Transactional(propagation=Propagation.NEVER)
    @Override
	public List<Pet> findPetByPrice(double price) {
		List<Pet> list = this.ipm.findPetByPrice(price);
		return list;
	}
    @Transactional(propagation=Propagation.NEVER)
    @Override
	public List<Pet> findPetByCategory(String category) {
		List<Pet> list = this.ipm.findPetByCategory(category);
		return list;
	}
    @Transactional(propagation=Propagation.NEVER)
    @Override
	public List<Pet> findAllpet() {
		List<Pet> list = this.ipm.findAllpet();
		return list;
	}

}
