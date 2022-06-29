package com.employee.service;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(Integer id);
}
