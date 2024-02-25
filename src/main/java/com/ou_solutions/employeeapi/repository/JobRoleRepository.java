package com.ou_solutions.employeeapi.repository;

import com.ou_solutions.employeeapi.entity.JobRoleDO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRoleRepository extends JpaRepository<JobRoleDO,Long> {
}
