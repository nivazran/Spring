package com.niv.companyLab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.niv.companyLab.beans.Employee;
import com.niv.companyLab.beans.EmployeeList;
import com.niv.companyLab.service.CompanyServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {

	private final CompanyServiceImpl companyServiceImpl;

	@PostMapping("employees")
	@ResponseStatus(code = HttpStatus.CREATED)
	public long addEmployee(@RequestBody Employee employee) {
		companyServiceImpl.addEmployee(employee);
		return employee.getId();
	}

	@GetMapping("employees/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Employee getSingleEmployeeByID(@PathVariable long id) {
		return companyServiceImpl.getSingleEmployeeById(id);
	}

	@GetMapping("employees")
	public ResponseEntity<?> getAllEmployees() {
		return new ResponseEntity<>(new EmployeeList(companyServiceImpl.getAllEmployees()), HttpStatus.OK);
	}

	@GetMapping("employees/name")
	public ResponseEntity<?> getEmployeesByName(@RequestParam String name) {
		return new ResponseEntity<>(new EmployeeList(companyServiceImpl.getEmployeesByName(name)), HttpStatus.OK);
	}

}
