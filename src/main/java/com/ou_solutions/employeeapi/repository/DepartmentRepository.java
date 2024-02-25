package com.ou_solutions.employeeapi.repository;

import com.ou_solutions.employeeapi.entity.DepartmentDO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentDO,Long> {

    public Optional<DepartmentDO> findByDepartmentName(String departmentName);
}
