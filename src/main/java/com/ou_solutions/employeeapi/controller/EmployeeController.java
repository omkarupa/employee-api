package com.ou_solutions.employeeapi.controller;


import com.ou_solutions.employeeapi.dto.BearerToken;
import com.ou_solutions.employeeapi.dto.EmployeeRequest;
import com.ou_solutions.employeeapi.entity.EmployeeDO;
import com.ou_solutions.employeeapi.exceptions.DepartmentNotFoundException;
import com.ou_solutions.employeeapi.exceptions.JobRoleNotFoundException;
import com.ou_solutions.employeeapi.security.JwtTokenUtil;
import com.ou_solutions.employeeapi.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/sign-up")
    public EmployeeDO saveEmployee(@RequestBody @Valid EmployeeRequest request) throws JobRoleNotFoundException, DepartmentNotFoundException {
        return employeeService.saveEmployee(request);
    }

    @PostMapping("/jwt/sign-up")
    public ResponseEntity<?> saveJwtEmployee(@RequestBody @Valid EmployeeRequest request) throws JobRoleNotFoundException, DepartmentNotFoundException {

        EmployeeDO employeeDO =  employeeService.saveEmployee(request);

        String token = jwtTokenUtil.generateToken(employeeDO.getUserDO().getUsername());

        return new ResponseEntity<>( BearerToken.build(token,"Bearer "), HttpStatus.OK);
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
