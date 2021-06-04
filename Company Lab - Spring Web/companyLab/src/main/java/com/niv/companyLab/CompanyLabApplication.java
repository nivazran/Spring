package com.niv.companyLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CompanyLabApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CompanyLabApplication.class, args);
		System.out.println("Niv Company Lab - Spring IoC container was loaded !");
	}

}
