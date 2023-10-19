package com.product.blog.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.blog.exceptions.*;

import com.product.blog.entity.User;
import com.product.blog.payloads.UserDto;
import com.product.blog.repositories.UserRepo;
import com.product.blog.service.UserService;
import com.product.blog.entity.*;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	
	private UserRepo userRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User saveduser = this.userRepo.save(user);
		return this.userToDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName()); 
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(() ->new ResourceNotFoundException("User","Id",userId));
		return null;
	}

	@Override 
	public List<UserDto> getAllUser() {
	  List<User> users = this.userRepo.findAll();
	 List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
	  
		return userDtos;
	}
	
	
	
	private User dtoToUser(UserDto userDto) {
	    User user= this.modelMapper.map(userDto, User.class);
	       return user;
    }
	
	private UserDto userToDto(User user ) {
	    UserDto userDto = this.modelMapper.map(user, UserDto.class);
	       return userDto;
    }

	@Override
	public void deleteOneUser(Integer uid) {
		User user = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("user", "userId", uid));
		     userRepo.delete(user);
		
	}
	
}
