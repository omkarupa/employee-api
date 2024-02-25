package com.ou_solutions.employeeapi.repository;

import com.ou_solutions.employeeapi.entity.AddressDO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressDO,Long> {
}
