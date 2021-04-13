package edu.xufe.mapper;

import java.util.List;

import edu.xufe.entity.Manager;

public interface IManagerMapper {
	//查询管理员
	List<Manager> findByNumber(int number); 

}
