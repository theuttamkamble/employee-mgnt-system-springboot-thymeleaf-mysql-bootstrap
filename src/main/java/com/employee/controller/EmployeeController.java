package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entities.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/add")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "/views/create_employee";
	}
	
	@PostMapping("/processform")
	public String processEmployeeForm(@ModelAttribute Employee employee, Model model) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "/views/list_employees";
	}
	
	@GetMapping("/employee/update/{id}")
	public String updateEmployee(@PathVariable Integer id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "/views/update_employee";
	}
	
	@PostMapping("/updateform/{id}")
	public String processUpdateEmployee(@PathVariable Integer id, @ModelAttribute Employee employee, Model model) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		
		existingEmployee.setId(id);
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setCity(employee.getCity());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setMobile(employee.getMobile());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setSalary(employee.getSalary());
		
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
