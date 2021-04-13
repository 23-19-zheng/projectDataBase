package com.djs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djs.entity.Citizen;
@Repository
public interface ICitizenDao extends JpaRepository<Citizen, Integer>{
     List<Citizen> findByNumberAndPassword(Integer number,String password);
     
}
