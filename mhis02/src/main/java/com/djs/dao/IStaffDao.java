package com.djs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djs.entity.Staff;
@Repository
public interface IStaffDao extends JpaRepository<Staff, Integer> {
	List<Staff> findByNumberAndPassword(Integer number,String password);

}
