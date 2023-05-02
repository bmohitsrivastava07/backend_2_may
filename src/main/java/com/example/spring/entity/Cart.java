package com.example.spring.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int cartId;
	
	
	private int productId;
	private int userId;
	private Date createdDate;
	private int cartQuantity;
	
	
}
