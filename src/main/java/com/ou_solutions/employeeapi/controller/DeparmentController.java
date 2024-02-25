package com.ou_solutions.employeeapi.controller;

import com.ou_solutions.employeeapi.dto.DepartmentRequest;
import com.ou_solutions.employeeapi.entity.DepartmentDO;
import com.ou_solutions.employeeapi.exceptions.DepartmentNotFoundException;
import com.ou_solutions.employeeapi.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DeparmentController {

    private final DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public DepartmentDO saveDepartment(@RequestBody DepartmentRequest request) {
        return departmentService.saveDepartment(request.getDepartmentName());
    }

    private List<DepartmentDO> getAllDepartments()
    {
        return departmentService.getAllDeparments();
    }

    @GetMapping("/{departmentName}")
    private DepartmentDO getDepartmentByDepartmentName(@PathVariable String departmentName) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(departmentName);
    }

    @GetMapping("/id/{id}")
    private DepartmentDO getDepartmentbyId(@PathVariable Long id) throws DepartmentNotFoundException {
        return  departmentService.getDepartmentById(id);
    }

}
