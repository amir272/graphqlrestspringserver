package com.example.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.assignment.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String>{

	@Query(value = "SELECT * FROM product WHERE product_name LIKE %:productName%", nativeQuery = true)
	public List<Product> findByProductName(@Param("productName")String productName);

}
