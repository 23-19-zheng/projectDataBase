package com.djs.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djs.entity.MedicalNews;
@Repository//被spring管理起来【可以理解为spring的储存库，为自己创建接口对象访问数据库】
public interface IMedicalNewsDao extends JpaRepository<MedicalNews, Integer> {
     void deleteByTitle(String title);
     List<MedicalNews> findAllById(Integer id);
     List<MedicalNews> findAllByTitle(String title);
     List<MedicalNews> findAllByAuthor(String author);
     List<MedicalNews> findAllByDate(Date date);
}
