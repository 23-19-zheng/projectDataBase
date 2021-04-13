package edu.xufe.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @AllArgsConstructor
	@NoArgsConstructor
	@Data
	@Alias("Customer")//别名【在Mapper配置文件中需要使用】
public class Customer {
	
	private Integer id;//序号
	private Integer number;//账号
	private String password;//密码
	private String name;//姓名
	private String address;//地址
	private Pet pet;//顾客购买的宠物

}
