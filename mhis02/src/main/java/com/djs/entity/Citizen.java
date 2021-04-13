package com.djs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="citizen_tab")
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="citizen_id")
	private Integer id;
	@Column(name="citizen_number")
	private Integer number;
	@Column(name="citizen_password")
	private String password;
	@Column(name="citizen_name")
	private String name;
	@Column(name="citizen_age")
	private Integer age;
	@Column(name="citizen_gender")
	private String gender;
	@Column(name="citizen_IDCard")
	private String idcard;
	@Column(name="citizen_cost")
	private Double cost;//医疗缴费
	@Column(name="citizen_condition")
    private String condition;//个人状态【学生，公民等】
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Citizen() {
		super();
	}
	
	
	public Citizen(Integer id, Integer number, String password, String name, Integer age, String gender, String idcard,
			Double cost, String condition) {
		super();
		this.id = id;
		this.number = number;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.idcard = idcard;
		this.cost = cost;
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", number=" + number + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", idcard=" + idcard + ", cost=" + cost + ", condition=" + condition + "]";
	}
	
    
}
