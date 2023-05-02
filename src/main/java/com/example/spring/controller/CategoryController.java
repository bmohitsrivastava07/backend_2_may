package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import com.example.spring.entity.Category;
import com.example.spring.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
    
	@PostMapping("/create")
	public ResponseEntity<String> createCategory(@RequestBody Category category) {
		this.categoryService.createCategory(category);
		return new ResponseEntity<>("a new category is created",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/listofcategory")
	public List<Category> listCategory(){
		return this.categoryService.listCategory();
	}
	
	@PostMapping("/edit/{categoryId}")
	public ResponseEntity<String> editCategory(@PathVariable("categoryId") int categoryId,@RequestBody Category updateCategory) {
		if(!categoryService.findById(categoryId)) {
			return new ResponseEntity<>("Category does not exist",HttpStatus.NOT_FOUND);
		}
		else {
			this.categoryService.editCategory(categoryId, updateCategory);
			return new ResponseEntity<>("Category is updated",HttpStatus.OK);
		}
	}
}
