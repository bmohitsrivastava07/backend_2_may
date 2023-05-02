package com.example.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.entity.Category;

public interface CategoryService {

	public void createCategory(Category category);
	public List<Category> listCategory();
	public void editCategory(int categoryId, Category updateCategory);
	public boolean findById(int categoryId);
}
