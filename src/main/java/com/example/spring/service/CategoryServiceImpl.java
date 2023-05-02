package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Category;
import com.example.spring.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public void createCategory(Category category) {
			categoryRepository.save(category);	
	}

	@Override
	public List<Category> listCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public void editCategory(int categoryId, Category updateCategory) {
		Category category= categoryRepository.getById(categoryId);
		category.setCategoryName(updateCategory.getCategoryName());
		category.setCategoryDescription(updateCategory.getCategoryDescription());
		category.setCategoryImage(updateCategory.getCategoryImage());
		categoryRepository.save(category);
	}

	@Override
	public boolean findById(int categoryId) {
		
		return categoryRepository.findById(categoryId).isPresent();
	}
   
}
