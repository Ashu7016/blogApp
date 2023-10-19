package com.product.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
