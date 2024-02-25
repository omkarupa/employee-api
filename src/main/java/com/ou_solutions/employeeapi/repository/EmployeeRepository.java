package com.ou_solutions.employeeapi.repository;

import com.ou_solutions.employeeapi.entity.EmployeeDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDO,Long> {
}
