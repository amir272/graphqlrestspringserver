package com.example.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.entity.Product;
import com.example.assignment.repo.ProductRepo;

@Service
public class ProductServiceIMPL implements ProductService{
	
	@Autowired
	ProductRepo productRepo;
	
	public List<Product> getALL() {
		return productRepo.findAll();
	}
	
	public List<Product> findByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}
	
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

}
