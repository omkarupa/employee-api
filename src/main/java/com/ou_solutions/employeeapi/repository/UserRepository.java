package com.ou_solutions.employeeapi.repository;

import com.ou_solutions.employeeapi.entity.UserDO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDO,Long> {
    Optional<UserDO> findByUsername(String username);
}
