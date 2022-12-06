package com.createiq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@PostMapping("/add")
	public Employee add(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

}
