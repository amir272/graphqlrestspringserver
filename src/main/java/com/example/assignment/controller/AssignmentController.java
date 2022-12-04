package com.example.assignment.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.assignment.AssignmentApplication;
import com.example.assignment.entity.Employee;
import com.example.assignment.entity.Manufacturer;
import com.example.assignment.entity.Product;
import com.example.assignment.service.EmployeeService;
import com.example.assignment.service.ManufactureService;
import com.example.assignment.service.ProductService;

@RestController
public class AssignmentController implements GraphQLQueryResolver, GraphQLMutationResolver {

	private static final Logger logger = LogManager.getLogger(AssignmentApplication.class);
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ManufactureService manufactureService;

	
	@QueryMapping("findProdByName")
	public List<Product> findProdByName(@Argument String name){
		List<Product> listProducts = null;
		try {
		listProducts = productService.findByProductName(name);
		}catch (Exception e) {
			logger.error( e);
		}
		return listProducts;
	}
	
	@QueryMapping("findManufacturer")
	public List<Manufacturer> findManufacturer(@Argument String name){
		List<Manufacturer> listManufacturers = null;
        try {
        	listManufacturers =  manufactureService.findByName(name);
		} catch (Exception e) {
			logger.fatal(e);
		}
		return listManufacturers;
	}

	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/add")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee)
	{
		Employee emp = null;
		try {
			emp = employeeService.addEmployee(employee);
		} catch (Exception e) {
			logger.error(e);
		}
		    
	    return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/addprod")
	public ResponseEntity<Product> addProduct (@RequestBody Product product)
	{
		Product prod = null;
		try {
			prod = productService.addProduct(product);
		} catch (Exception e) {
			logger.error(e);
		}
		    
	    return new ResponseEntity<>(prod, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/emp/{email}/{password}")
	public ResponseEntity<Employee> getEmpByEmail(@PathVariable("email") String email, @PathVariable("password") String password)
	{	    
		Employee employee = null;
		try {
			employee = employeeService.getEmpByEmail(email, password);
		} catch (Exception e) {
			logger.error(e);
		}
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	}


}
