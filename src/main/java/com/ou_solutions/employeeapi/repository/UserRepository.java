package com.ou_solutions.employeeapi.repository;

import com.ou_solutions.employeeapi.entity.UserDO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDO,Long> {
}
