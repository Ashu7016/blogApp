package com.product.blog.service;

import java.util.List;

import com.product.blog.payloads.CategoryDto;

public interface CategoryService {
	
	 //create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	public CategoryDto deleteCategory(Integer categoryId);
	
	//get
	public CategoryDto getCategory(Integer categoryId);
	
	//get All
	List<CategoryDto> getCategories();



}
