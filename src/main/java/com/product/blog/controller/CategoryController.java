package com.product.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.blog.payloads.ApiResponse;
import com.product.blog.payloads.CategoryDto;
import com.product.blog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	//create
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
      CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
      return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
}
	
	//update
	
	@PutMapping("{/catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryId,@PathVariable Integer catId){
	      CategoryDto createCategory = this.categoryService.updateCategory(categoryId,catId);
	      return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	
	      
	  }
	  	
	  	//update
	  	
	  /**	@PutMapping("{/catId}")
	 	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryId,@PathVariable Integer catId){
	  	      CategoryDto createCategory = this.categoryService.updateCategory(categoryId,catId);
	  	     return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	  	
	  	
	  }
*/
	
	//Delete
//	@DeleteMapping("{/catId}")
//	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
//
//		CategoryDto createCategory = this.categoryService.deleteCategory(catId);
//	      return new ResponseEntity<ApiResponse>((HttpStatusCode) new ApiResponse("category is deleted successful !!",true));
//
//}
	
	//get
	
	@GetMapping("{/catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
	  CategoryDto categoryDto = this.categoryService.getCategory(catId);
	  return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
}
	//get all
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
	  List<CategoryDto> categories = this.categoryService.getCategories();
	  return ResponseEntity.ok(categories);
}
	
}
