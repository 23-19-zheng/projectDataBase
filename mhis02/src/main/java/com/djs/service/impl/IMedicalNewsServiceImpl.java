package com.djs.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djs.dao.IMedicalNewsDao;
import com.djs.entity.MedicalNews;
import com.djs.service.IMedicalNewsService;
@Service
@Transactional
public class IMedicalNewsServiceImpl implements IMedicalNewsService {
	@Autowired
	private IMedicalNewsDao imnd;
	private List<MedicalNews> list;
    /*
     * 增加新闻
     */
	public void add(MedicalNews m) {
		imnd.save(m);
		
	}
    /*
     * 删除新闻
     */
	public void deleteByTitle(String title) {
		imnd.deleteByTitle(title);
		
	}
    /*
     * 修改新闻
     */
	public void update(MedicalNews m) {
		imnd.save(m);
		
	}
    /*
     * 按照序号查询新闻
     */
	public List<MedicalNews> findById(Integer id) {
		list = imnd.findAllById(id);
		return list;
	}
    /*
     * 按照标题查询新闻
     */
	public List<MedicalNews> findByTitle(String title) {
		list = imnd.findAllByTitle(title);
		return list;
	}
    /*
     * 按照发布者查新新闻
     */
	public List<MedicalNews> findByAuthor(String author) {
		list = imnd.findAllByAuthor(author);
		return list;
	}
    /*
     * 按照发布时间查询新闻
     */
	public List<MedicalNews> findByDate(Date date) {
		list = imnd.findAllByDate(date);
		return list;
	}

}
