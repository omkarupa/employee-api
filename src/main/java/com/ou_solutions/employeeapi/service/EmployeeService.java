package com.ou_solutions.employeeapi.service;

import com.ou_solutions.employeeapi.dto.EmployeeRequest;
import com.ou_solutions.employeeapi.entity.EmployeeDO;
import com.ou_solutions.employeeapi.entity.UserDO;
import com.ou_solutions.employeeapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository empRepo;

    public EmployeeDO saveEmployee(EmployeeRequest request)
    {
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

    public EmployeeDO mapFromEmployeeRequest(EmployeeRequest request)
    {
        UserDO userDO = UserDO.build(0l,request.getEmailId(), request.getPassword(), request.getMobile(), null);


        return EmployeeDO.build(0L,request.getName(), request.getEmailId(), request.getSalary(), request.getMobile(),userDO);
    }

}
