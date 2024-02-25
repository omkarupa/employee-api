package com.ou_solutions.employeeapi.service;

import com.ou_solutions.employeeapi.dto.DepartmentRequest;
import com.ou_solutions.employeeapi.entity.DepartmentDO;
import com.ou_solutions.employeeapi.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private DepartmentRepository deptRepo;

    public DepartmentDO saveDepartment(String departmentName)
    {
        return null;
    }

    public DepartmentDO getDepartmentById(Long id)
    {
        return deptRepo.findById(id).orElse(new DepartmentDO());
    }

    public List<DepartmentDO> getAllDeparments()
    {
        return deptRepo.findAll();
    }

    public DepartmentDO mapFromDepartmentRequest(String deparmtentName)
    {
        return DepartmentDO.build(0L, deparmtentName);
    }


}
