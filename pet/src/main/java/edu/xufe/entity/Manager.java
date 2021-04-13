package edu.xufe.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias("Manager")
public class Manager {
	/*
	 * 管理员/商家
	 * 管理员/商家可对宠物及其顾客进行管理
	 */
	private Integer id;//序号
	private Integer number;//账号
	private String password;//密码
	private String name;//姓名

}
