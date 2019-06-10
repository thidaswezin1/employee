package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import javax.annotation.PostConstruct;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	/*
	 * private List<Employee> theEmployee;
	 * 
	 * @PostConstruct public void loadData() { Employee employee1 = new
	 * Employee(1,"Thida","Swe Zin","thida@gmail.com"); Employee employee2 = new
	 * Employee(1,"Khin","Swe Zin","khin@gmail.com"); Employee employee3 = new
	 * Employee(1,"Kyaw","Swe Zin","kyaw@gmail.com");
	 * 
	 * theEmployee = new ArrayList<>(); theEmployee.add(employee1);
	 * theEmployee.add(employee2); theEmployee.add(employee3);
	 * 
	 * }
	 */
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theemployeeService) {
		employeeService=theemployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		List<Employee> list = employeeService.findAll();
		model.addAttribute("employees", list);
		return "employees/list_employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee_form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id,Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employees/employee_form";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
		
	}
	
	

}
