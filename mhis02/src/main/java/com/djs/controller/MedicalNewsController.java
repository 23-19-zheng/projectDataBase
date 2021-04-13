package com.djs.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.MedicalNews;
import com.djs.json.HttpResp;
import com.djs.service.impl.IMedicalNewsServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController

public class MedicalNewsController {
	@Autowired
	private IMedicalNewsServiceImpl imnsi;
	private List<MedicalNews> list;
	/*
	 * 增加新闻
	 */
	@GetMapping("addMedicalNews.action")
	
	public HttpResp add(String title,String author,String content,@JsonFormat @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
	    MedicalNews m = new MedicalNews(title, author, content, date);
		System.out.println(m);
		imnsi.add(m);
		return new HttpResp(200,"添加成功",null,LocalDateTime.now());
	}
	/*
	 * 删除新闻
	 */
	@DeleteMapping("deleteMedicalNews.action")
    public HttpResp delete(String title) {
    	imnsi.deleteByTitle(title);
		return new HttpResp(200,"删除成功",null,LocalDateTime.now());
	}
	/*
	 * 修改新闻
	 */
	@PostMapping("updateMedicalNews.action")
    public HttpResp upadte(@RequestBody MedicalNews m) {
		System.out.println(m);
    	imnsi.update(m);
		return new HttpResp(200,"修改成功",null,LocalDateTime.now());
	}
	/*
	 * 查询新闻
	 */
    @PutMapping("fingByIdMedicalNews.action")
    public HttpResp findById(Integer id) {
    	System.out.println("我倒这里了："+id);
    	list = imnsi.findById(id);
		return new HttpResp(200,"查询成功",list,LocalDateTime.now());
	}
    @PutMapping("fingByAuthorMedicalNews.action")
    public HttpResp findByAuthor(String author) {
    	list = imnsi.findByAuthor(author);
		return new HttpResp(200,"查询成功",list,LocalDateTime.now());
	}
    @PutMapping("fingByTitleMedicalNews.action")
    public HttpResp findByTitle(String title) {
    	list = imnsi.findByTitle(title);
    	return new HttpResp(200,"查询成功",list,LocalDateTime.now());
    }
    @PutMapping("fingByDateMedicalNews.action")
    public HttpResp findBydate(@JsonFormat @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    	list = imnsi.findByDate(date);
    	return new HttpResp(200,"查询成功",list,LocalDateTime.now());
    }

}
