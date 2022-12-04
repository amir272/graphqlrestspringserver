package com.example.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.assignment.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query(value = "SELECT * FROM employee WHERE email = :email AND password = :password LIMIT 1", nativeQuery = true)
	public Employee findByEmail(@Param("email")String email, @Param("password")String password);
	
	@Query(value = "SELECT * FROM employee WHERE first_name LIKE %:firstName%", nativeQuery = true)
	public List<Employee> findByFirstName(@Param("firstName")String firstName);

}