package com.example.assignment.service;

import java.util.List;

import com.example.assignment.entity.Product;

public interface ProductService {

	public List<Product> getALL();
	public List<Product> findByProductName(String productName);
	public Product addProduct(Product product);

}
