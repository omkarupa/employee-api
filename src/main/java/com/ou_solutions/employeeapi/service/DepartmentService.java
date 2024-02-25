package com.ou_solutions.employeeapi.service;

import com.ou_solutions.employeeapi.entity.DepartmentDO;
import com.ou_solutions.employeeapi.exceptions.DepartmentNotFoundException;
import com.ou_solutions.employeeapi.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository deptRepo;

    public DepartmentDO saveDepartment(String departmentName)
    {
            return deptRepo.save(mapFromDepartmentRequest(departmentName));
    }

    public DepartmentDO getDepartmentById(Long id) throws DepartmentNotFoundException {
        return deptRepo.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department Not Found for " + id));
    }

    public DepartmentDO getDepartmentByName(String  departmentName) throws DepartmentNotFoundException {
        return deptRepo.findByDepartmentName(departmentName).orElseThrow(() -> new DepartmentNotFoundException("Department Not Found for " + departmentName));
    }

    public List<DepartmentDO> getAllDeparments()
    {
        return deptRepo.findAll();
    }

    public DepartmentDO mapFromDepartmentRequest(String deparmtentName)
    {
        return DepartmentDO.build(0L, deparmtentName,null);
    }




}
