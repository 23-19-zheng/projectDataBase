package com.djs.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.djs.entity.MedicalNews;

public interface IMedicalNewsService {
	void add(MedicalNews m);
	void deleteByTitle(String title);
	void update(MedicalNews m);
	List<MedicalNews> findById(Integer id);
    List<MedicalNews> findByTitle(String title);
	List<MedicalNews> findByAuthor(String author);
	List<MedicalNews> findByDate(Date date);
}
