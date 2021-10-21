package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.mapper.mybatis.UserMapper;

@RestController
public class Teste {
	@Autowired
	UserMapper mapper;
	@GetMapping("/")
	public String success() {
		
		return "success method";
	}

}
