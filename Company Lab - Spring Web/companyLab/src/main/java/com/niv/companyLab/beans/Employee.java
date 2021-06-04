package com.niv.companyLab.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employees")
@Entity
public class Employee {

	@Id
	private long id;
	private String name;
	private double salary;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Singular
	private List<Job> jobs = new ArrayList<Job>();
}