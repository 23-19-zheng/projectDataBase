package com.djs.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager_tab")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manager_id")
	private Integer id;
	@Column(name = "manager_number")
	private Integer number;
	@Column(name="manager_password")
	private String password;
	public Manager() {
		super();
	}
	
	public Manager(Integer number, String password) {
		super();
		this.number = number;
		this.password = password;
	}

	public Manager(Integer id, Integer number, String password) {
		super();
		this.id = id;
		this.number = number;
		this.password = password;
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

	@Override
	public String toString() {
		return "Manager [id=" + id + ", number=" + number + ", password=" + password + "]";
	}
	

    
}
