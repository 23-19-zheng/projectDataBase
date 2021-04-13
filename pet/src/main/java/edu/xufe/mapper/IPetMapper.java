package edu.xufe.mapper;

import java.util.List;

import edu.xufe.entity.Pet;

/**
 * mybaits接口
 * @author zc
 *
 */
public interface IPetMapper {
	//添加宠物
	void add(Pet pet);
	
	//清除宠物
	void delete(int number);
	
	//修改宠物
	void update(Pet pet);
	
	//查询宠物
	List<Pet> findPetByNumber(int number);//编号查询
	List<Pet> findPetByName(String name);//名称查询
	List<Pet> findPetByPrice(double price);//价格查询
	List<Pet> findPetByCategory(String category);//类别查询
	List<Pet> findAllpet();//查询所有的宠物【但是建议在数据庞大的情况下不用劝查询，因效率很慢，数据库SQL语句优化，可用模糊查询增加查询效率或者建立索引页可】
     
}
