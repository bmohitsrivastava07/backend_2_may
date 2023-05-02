package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
