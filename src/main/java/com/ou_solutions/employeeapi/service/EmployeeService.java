package com.ou_solutions.employeeapi.service;

import com.ou_solutions.employeeapi.dto.EmployeeRequest;
import com.ou_solutions.employeeapi.entity.*;
import com.ou_solutions.employeeapi.exceptions.DepartmentNotFoundException;
import com.ou_solutions.employeeapi.exceptions.JobRoleNotFoundException;
import com.ou_solutions.employeeapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository empRepo;

    private final JobRoleService jobRoleService;

    private final DepartmentService deptService;

    private final PasswordEncoder encoder;

    public EmployeeDO saveEmployee(EmployeeRequest request) throws JobRoleNotFoundException, DepartmentNotFoundException {
        return empRepo.save(mapFromEmployeeRequest(request));
    }

    public EmployeeDO getEmployeeById(Long id)
    {
        return empRepo.findById(id).orElse(new EmployeeDO());
    }

    public List<EmployeeDO> getAllEmployees()
    {
        return empRepo.findAll();
    }

    public EmployeeDO mapFromEmployeeRequest(EmployeeRequest request) throws JobRoleNotFoundException, DepartmentNotFoundException {

        UserDO userDO = UserDO.build(0L,request.getEmailId(), encoder.encode(request.getPassword()), request.getMobile(), "USER",null);

        AddressDO addressDO = AddressDO.build(0L, request.getStreetName(), request.getCity(), null);

        JobRoleDO jobRoleDO = jobRoleService.findJobRoleByName(request.getJobRole());

        DepartmentDO departmentDO =  deptService.getDepartmentByName(request.getDepartment());

        return EmployeeDO.build(0L,request.getName(), request.getEmailId(), request.getSalary(), request.getMobile(),userDO,addressDO,jobRoleDO,departmentDO);
    }

}
