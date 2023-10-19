package com.product.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.blog.payloads.ApiResponse;
import com.product.blog.payloads.UserDto;
import com.product.blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	

	@Autowired
	private UserService userservice;
	
	
	//Post-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) 
	{
		UserDto createUserDto = this.userservice.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	
	

   }

//put-update user
  @PutMapping("/{id}")
   public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("id")Integer uid)
   {
   UserDto updatedUser = this.userservice.updateUser(userDto,uid);
   
    return ResponseEntity.ok(updatedUser);
   }
  
	//delete-delete user 
  
  @DeleteMapping("/{userId}")
  public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
	    userservice.deleteOneUser(uid);
	  return new ResponseEntity(new ApiResponse("deleted ",false ),HttpStatus.OK);
	  
	
	  
  }
	//get-user get
   @GetMapping
  public ResponseEntity<List<UserDto>> getAllUser(){
	  return ResponseEntity.ok(this.userservice.getAllUser());
  }


@GetMapping("/")
public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
	  return ResponseEntity.ok(this.userservice.getUserById(userId));
  }
}










