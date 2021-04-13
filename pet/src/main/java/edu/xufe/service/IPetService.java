package edu.xufe.service;

import java.util.List;

import edu.xufe.entity.Pet;

public interface IPetService {
	void save(Pet pet);//添加宠物
	void delete(int number);//清除宠物
	void update(Pet pet);//修改宠物
	List<Pet> findPetByNumber(int number);//编号查询
	List<Pet> findPetByName(String name);//名称查询
	List<Pet> findPetByPrice(double price);//价格查询
	List<Pet> findPetByCategory(String category);//类别查询
	List<Pet> findAllpet();//查询所有的宠物

}
