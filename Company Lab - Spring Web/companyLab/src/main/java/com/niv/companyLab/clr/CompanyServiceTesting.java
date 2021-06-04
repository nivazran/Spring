package com.niv.companyLab.clr;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.niv.companyLab.utils.TestUtils;
import com.niv.companyLab.beans.Employee;
import com.niv.companyLab.beans.EmployeeList;
import com.niv.companyLab.beans.Job;
import com.niv.companyLab.repos.JobRepository;
import com.niv.companyLab.service.CompanyServiceImpl;
import com.niv.companyLab.utils.ArtUtils;
import com.niv.companyLab.utils.DateUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Order(1)
public class CompanyServiceTesting implements CommandLineRunner {

	private final CompanyServiceImpl companyServiceImpl;
	private final JobRepository jobRepository;

	private final RestTemplate restTemplate;
	private static final String URL = "http://localhost:8080/company";

	@Override
	public void run(String... args) throws Exception {

		System.out.println(ArtUtils.companyServiceTesting);

		Job j1 = Job.builder().id(25).description("Java Course 129 - Company Lab")
				.endDate(Date.valueOf(LocalDate.of(2022, 06, 03))).build();

		Job j2 = Job.builder().id(63).description("Organize Companie's Purim Celebration")
				.endDate(Date.valueOf(LocalDate.of(2023, 01, 01))).build();

		Job j3 = Job.builder().id(45).description("Finish configure customer's system")
				.endDate(Date.valueOf(LocalDate.of(2022, 06, 03))).build();

		Job j4 = Job.builder().id(56).description("Fill work time for last month")
				.endDate(Date.valueOf(LocalDate.of(2021, 07, 01))).build();

		Job j5 = Job.builder().id(36).description("Fill 'New Employee Documents'")
				.endDate(Date.valueOf(LocalDate.of(2023, 03, 25))).build();

		Job j6 = Job.builder().id(100).description("Buy birthday's present to manager")
				.endDate(Date.valueOf(LocalDate.of(2022, 12, 30))).build();

		Job j7 = Job.builder().id(312).description("Read and response to your waiting email messages")
				.endDate(Date.valueOf(LocalDate.of(2022, 02, 28))).build();

		Job j8 = Job.builder().id(134).description("Complete to write the code for customer")
				.endDate(Date.valueOf(LocalDate.of(2022, 06, 03))).build();

//		Employee e1 = Employee.builder().id(325363961).name("Niv Azran").salary(15000).job(j1).job(j2).build();

		Employee e2 = Employee.builder().id(152363252).name("Kobi Shasha").salary(20000).job(j3).job(j4).build();

		Employee e3 = Employee.builder().id(845210201).name("Niv Azran").salary(17500).job(j5).job(j6).build();

		Employee e4 = Employee.builder().id(745111254).name("Kobi Shasha").salary(13000).job(j7).job(j8).build();

		TestUtils.testInfo("addEmployee");
//		companyServiceImpl.addEmployee(e1);
		companyServiceImpl.addEmployee(e2);
		companyServiceImpl.addEmployee(e3);
		companyServiceImpl.addEmployee(e4);

		companyServiceImpl.getAllEmployees().forEach(System.out::println);

		TestUtils.testInfo("getSingleEmployeeById");

		System.out.println(companyServiceImpl.getSingleEmployeeById(152363252));

		TestUtils.testInfo("getEmployeesByName");

		companyServiceImpl.getEmployeesByName("Niv Azran").forEach(System.out::println);

		TestUtils.testInfo("getAllEmployees");

		companyServiceImpl.getAllEmployees().forEach(System.out::println);

		TestUtils.testInfo("getAllJobs");

		companyServiceImpl.getAllJobs().forEach(System.out::println);

		TestUtils.testInfo("getJobsByEndDate");

		companyServiceImpl.getJobsByEndDate(Date.valueOf(LocalDate.of(2022, 06, 03))).forEach(System.out::println);

		TestUtils.testInfo("getJobsBetween");

		companyServiceImpl
				.getJobsBetween(Date.valueOf(LocalDate.of(2021, 01, 01)), Date.valueOf(LocalDate.of(2023, 01, 01)))
				.forEach(System.out::println);

		// Rest Template

		TestUtils.testInfo("Add Employee - REST Template");
		Employee e5 = Employee.builder().id(33356961).name("Yam Azran").salary(25000).job(j1).job(j2).build();
		ResponseEntity<String> res = restTemplate.postForEntity(URL + "/employees", e5, String.class);
		System.out.println("Created Employee ID is - " + res.getBody());

		TestUtils.testInfo("Get All Employees - REST Template");
		EmployeeList res2 = restTemplate.getForObject(URL + "/employees", EmployeeList.class);
		res2.getEmployees().forEach(System.out::println);

		TestUtils.testInfo("Get Employees By Name - REST Template");
		EmployeeList res3 = restTemplate.getForObject(URL + "/employees/name?name=" + e3.getName(), EmployeeList.class);
		res3.getEmployees().forEach(System.out::println);

		TestUtils.testInfo("Get Employee By ID - REST Template");
		Employee res4 = restTemplate.getForObject(URL + "/employees/" + e3.getId(), Employee.class);
		System.out.println(res4);

		System.out.println();
		System.out.println("---------------------------------------------------");

	}

}
