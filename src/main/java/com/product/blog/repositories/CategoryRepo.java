package com.product.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
