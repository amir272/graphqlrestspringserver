package com.example.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.entity.Employee;
import com.example.assignment.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Override
	public Employee addEmployee(Employee name) {
		return employeeRepo.save(name);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee getEmpByEmail(String email, String password) {
		return employeeRepo.findByEmail(email, password);
	}

	@Override
	public List<Employee> getEmployees(String firstName) {
		return employeeRepo.findByFirstName(firstName);
	}

}
