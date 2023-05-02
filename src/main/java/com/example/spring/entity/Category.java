package com.example.spring.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {

	@Id 
	@Column(unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(nullable=false)
	private String categoryName;
	
	@Lob
	@Column(nullable=false)
	private byte[] categoryImage;
	
	@Column(nullable=false)
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Product> product;
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryId, String categoryName, byte[] categoryImage, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
		this.categoryDescription = categoryDescription;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public byte[] getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(byte[] categoryImage) {
		this.categoryImage = categoryImage;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	
}
