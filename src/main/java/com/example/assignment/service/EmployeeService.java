package com.example.assignment.service;

import java.util.List;

import com.example.assignment.entity.Employee;

public interface EmployeeService {
	    public Employee addEmployee(Employee name);
	    public List<Employee> getEmployees();
	    public Employee getEmployee(int id);
		public Employee getEmpByEmail(String email, String password);
		public List<Employee> getEmployees(String firstName);

}
