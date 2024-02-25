package com.ou_solutions.employeeapi.service;


import com.ou_solutions.employeeapi.entity.JobRoleDO;
import com.ou_solutions.employeeapi.exceptions.JobRoleNotFoundException;
import com.ou_solutions.employeeapi.repository.JobRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobRoleService {

    private final JobRoleRepository jobRoleRepo;

    public JobRoleDO saveJobRole(String jobRoleName) {
        return jobRoleRepo.save(mapFromJobRoleRequest(jobRoleName));
    }

    public JobRoleDO getJobRoleById(Long id) throws JobRoleNotFoundException {
        return jobRoleRepo.findById(id).orElseThrow(() -> new JobRoleNotFoundException("JobRole Not found for " + id));
    }

    public List<JobRoleDO> getAllJobRoles() {
        return jobRoleRepo.findAll();
    }

    public JobRoleDO mapFromJobRoleRequest(String jobRoleName) {
        return JobRoleDO.build(0L, jobRoleName,null);
    }

    public JobRoleDO findJobRoleByName(String jobRoleName) throws JobRoleNotFoundException {
        return jobRoleRepo.findByJobRoleName(jobRoleName).orElseThrow(() -> new JobRoleNotFoundException("JobRole Not found for " + jobRoleName));

    }

}
