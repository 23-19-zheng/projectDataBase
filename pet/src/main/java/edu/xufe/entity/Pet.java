package edu.xufe.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias("Pet")//建议一般与类名一样
public class Pet {
	private Integer id;//宠物序号
	private Integer number;//宠物编号
	private String name;//宠物姓名
	private Integer age;//宠物年龄
	private Double price;//宠物价格
	private String color;//宠物颜色
	private String category;//宠物类别
	private String img;//宠物照片

}
