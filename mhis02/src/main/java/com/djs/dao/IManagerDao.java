package com.djs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.djs.entity.Manager;
@Repository
public interface IManagerDao extends JpaRepository<Manager, Integer> {
	//List<Manager> findAllByNumberAndPassWord(int number,String password);
	@Query(name="FROM Manager WHERE id=:id and password=:password")
	List<Manager> findAllByNumberAndPassword(int id,String password);
	
}
