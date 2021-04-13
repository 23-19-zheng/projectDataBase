package com.djs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="medicalnews_tab")
public class MedicalNews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="news_id")
	private int id;//新闻序号
	@Column(name="news_title")
	private String title;//新闻标题
	@Column(name="news_author")
	private String author;//新闻发布者
	@Column(name="news_content")
	private String content;//新闻内容
	@Column(name="news_date")
	private Date date;//新闻发布日期
	
	public MedicalNews() {
		super();
	}
	public MedicalNews(String title, String author, String content, Date date) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MedicalNews [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + ", date="
				+ date + "]";
	}
	

}
