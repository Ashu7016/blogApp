package com.product.blog.service;

import java.util.List;

import com.product.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto>getAllUser();
	void deleteOneUser(Integer uid);
	

}
