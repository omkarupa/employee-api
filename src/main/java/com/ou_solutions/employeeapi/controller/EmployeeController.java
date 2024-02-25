package com.ou_solutions.employeeapi.controller;


import com.ou_solutions.employeeapi.dto.EmployeeRequest;
import com.ou_solutions.employeeapi.entity.EmployeeDO;
import com.ou_solutions.employeeapi.exceptions.JobRoleNotFoundException;
import com.ou_solutions.employeeapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/sign-up")
    public EmployeeDO saveEmployee(@RequestBody EmployeeRequest request) throws JobRoleNotFoundException {
        return employeeService.saveEmployee(request);
    }

    @GetMapping("/{id}")
    public EmployeeDO getEmployeeById(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<EmployeeDO> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

}
