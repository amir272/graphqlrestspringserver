package com.example.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.assignment.entity.Manufacturer;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {
	
	@Query(value = "SELECT * FROM manufacturer WHERE name LIKE %:name%", nativeQuery = true)
	public List<Manufacturer> findByName(@Param("name")String name);

}