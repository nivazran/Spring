package com.niv.companyLab.service;

import java.sql.Date;
import java.util.List;

import com.niv.companyLab.beans.Employee;
import com.niv.companyLab.beans.Job;

public interface CompanyService {

	void addEmployee(Employee employee);

	Employee getSingleEmployeeById(long id);

	List<Employee> getEmployeesByName(String name);

	List<Employee> getAllEmployees();

	List<Job> getAllJobs();

	List<Job> getJobsByEndDate(Date endDate);

	List<Job> getJobsBetween(Date startDate, Date endDate);

}
