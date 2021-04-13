package com.djs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff_tab")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id")
	private Integer id;
	@Column(name="staff_number")
	private Integer number;
	@Column(name="staff_password")
	private String password;
	@Column(name="staff_name")
	private String name;
	@Column(name="staff_age")
	private Integer age;
	@Column(name="staff_position")
	private String position;//任职职位
	@Column(name="staff_delpartment")
    private String delpartment;//所在部门
	public Staff() {
		super();
	}
	public Staff(Integer id, Integer number, String password, String name, Integer age, String position,
			String delpartment) {
		super();
		this.id = id;
		this.number = number;
		this.password = password;
		this.name = name;
		this.age = age;
		this.position = position;
		this.delpartment = delpartment;
	}
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDelpartment() {
		return delpartment;
	}
	public void setDelpartment(String delpartment) {
		this.delpartment = delpartment;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", number=" + number + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", position=" + position + ", delpartment=" + delpartment + "]";
	}
    
}
