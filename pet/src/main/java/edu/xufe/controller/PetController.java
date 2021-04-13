package edu.xufe.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xufe.dto.ResponseResult;
import edu.xufe.entity.Pet;
import edu.xufe.service.IPetService;
@RestController
@RequestMapping("/api")

public class PetController {
	@Autowired
	private IPetService ips;
	/*
	 * 添加宠物
	 */
	@PutMapping("/addpet.action")
	public ResponseResult add(Pet pet) {
		ips.save(pet);
		return new ResponseResult(200, "添加成功", null, LocalDateTime.now());
	}
	/*
	 * 移除宠物
	 */
	@DeleteMapping("/delete.action")
	public ResponseResult dalete(int number) {
		ips.delete(number);
		return new ResponseResult(200, "移除成功", null, LocalDateTime.now());
	}
	/*
	 * 修改宠物
	 */
	@PostMapping("/update.action")
	public  ResponseResult update(Pet pet) {
		ips.update(pet);
		return new ResponseResult(200, "修改成功", null, LocalDateTime.now());
		
	}
	/*
	 * 查找宠物
	 */
	@GetMapping("/findAll.action")
	public ResponseResult findAllPet() {
		List<Pet> list = ips.findAllpet();
		return new ResponseResult(200, "查找成功", list, LocalDateTime.now());
		
	}
	@GetMapping("/findByNumber.action")
	public ResponseResult findPet(int number) {
		List<Pet> list = ips.findPetByNumber(number);
		return new ResponseResult(200, "查找成功", list, LocalDateTime.now());
		
	}
	@GetMapping("/findByName.action")
	public ResponseResult findPet(String name) {
		List<Pet> list = ips.findPetByName(name);
		return new ResponseResult(200, "查找成功",list, LocalDateTime.now());
		
	}
	@GetMapping("/findByPrice.action")
	public ResponseResult findPet(double price) {
		List<Pet> list = ips.findPetByPrice(price);
		return new ResponseResult(200, "查找成功", list, LocalDateTime.now());
		
	}
	@GetMapping("/findByCategory.action")
	public ResponseResult findPetByCateGory(String category) {
		List<Pet> list = ips.findPetByCategory(category);
		return new ResponseResult(200, "查找成功", list, LocalDateTime.now());
		
	}
	

}
