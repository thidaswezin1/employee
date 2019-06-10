package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int empId);
	public void save(Employee theEmployee);
	public void deleteById(int empId);
}
