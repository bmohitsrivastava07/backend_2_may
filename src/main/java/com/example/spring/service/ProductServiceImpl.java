package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.spring.entity.Category;
import com.example.spring.entity.Product;
import com.example.spring.repository.CategoryRepository;
import com.example.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired 
	CategoryRepository categoryRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductsById(int productId) {
		return this.productRepository.findById(productId).get();
	}

	@Override
	public void updateProduct(int productId,Product product) {
		if(this.productRepository.existsById(productId)) {
			product.setProductName(product.getProductName());
			product.setProductPrice(product.getProductPrice());
		    product.setProductImage(product.getProductImage());
		    product.setProductDescription(product.getProductDescription());
		    product.setProductQuantity(product.getProductQuantity());
		    product.setProductStatus(product.getProductStatus());
		    this.productRepository.save(product);
		}
		else {
			this.productRepository.save(product);
			
		}		
	}

	@Override
	public Boolean deleteProduct(int productId) {
		this.productRepository.deleteById(productId);
		return true;
		
	}

	@Override
	public void createProduct(Product product,int categoryId) {
	         Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	         
		     product.setCategory(category);
          productRepository.save(product);		
	}
     
}
