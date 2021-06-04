package com.niv.companyLab.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niv.companyLab.beans.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	List<Job> findByEndDate(Date endDate);

	List<Job> findJobByEndDateBetween(Date endDateStart, Date endDateEnd);
}
