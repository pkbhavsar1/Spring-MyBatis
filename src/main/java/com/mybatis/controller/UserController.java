package com.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

	@GetMapping("/all")
	public List<User> getAll(){
		System.out.println("ALL==>calling");
		return userMapper.findAll();
	}
	
	@PostMapping("/insert")
	public List<User> insert(@RequestBody User user){
		System.out.println("Insert==>Calling");
		userMapper.insert(user);
		return getAll();
	}
	
	@PutMapping("/update/{id}")
	public List<User> update(@PathVariable Long id, @RequestBody User user){
		System.out.println("Update Calling");
		delete(id);
		insert(user);
		return getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public List<User> delete(@PathVariable Long id){
		System.out.println("Delete==>Calling");
		userMapper.delete(id);
		return getAll();
	}
	
}
