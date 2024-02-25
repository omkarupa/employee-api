package com.ou_solutions.employeeapi.repository;

import com.ou_solutions.employeeapi.entity.DepartmentDO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentDO,Long> {
}
