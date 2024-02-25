package com.ou_solutions.employeeapi.controller;

import com.ou_solutions.employeeapi.dto.JobRoleRequest;
import com.ou_solutions.employeeapi.entity.JobRoleDO;
import com.ou_solutions.employeeapi.exceptions.JobRoleNotFoundException;
import com.ou_solutions.employeeapi.service.JobRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-role")
@RequiredArgsConstructor
public class JobRoleController {


    private final JobRoleService jobRoleService;

    @PostMapping("/saveJobRole")
    public JobRoleDO saveJobRole(@RequestBody JobRoleRequest request)
    {
        return jobRoleService.saveJobRole(request.getJobRoleName());
    }

    @GetMapping("/id/{id}")
    public JobRoleDO getJobRoleById(@PathVariable Long id) throws JobRoleNotFoundException {
        return jobRoleService.getJobRoleById(id);
    }

    @GetMapping("/{jobName}")
    public JobRoleDO getJobRoleByName(@PathVariable String jobName) throws JobRoleNotFoundException {
        return jobRoleService.findJobRoleByName(jobName);
    }

    @GetMapping("/all")
    public List<JobRoleDO> getAllJobRoles()
    {
        return jobRoleService.getAllJobRoles();
    }


}
