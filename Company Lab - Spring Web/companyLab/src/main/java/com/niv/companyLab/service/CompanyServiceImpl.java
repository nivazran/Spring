package com.niv.companyLab.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.niv.companyLab.beans.Employee;
import com.niv.companyLab.beans.Job;
import com.niv.companyLab.repos.EmployeeRepository;
import com.niv.companyLab.repos.JobRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

	private final EmployeeRepository employeeRepository;
	private final JobRepository jobRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployeeById(long id) {
		return employeeRepository.getOne(id);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return employeeRepository.getEmployeesByName(name);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public List<Job> getJobsByEndDate(Date endDate) {
		return jobRepository.findByEndDate(endDate);
	}

	@Override
	public List<Job> getJobsBetween(Date endDate, Date endDate2) {
		return jobRepository.findJobByEndDateBetween(endDate2, endDate2);
	}

}
