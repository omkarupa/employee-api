package com.ou_solutions.employeeapi.service;

import com.ou_solutions.employeeapi.dto.JobRoleRequest;
import com.ou_solutions.employeeapi.entity.JobRoleDO;
import com.ou_solutions.employeeapi.repository.JobRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobRoleService {

    private final JobRoleRepository jobRoleRepo;

    public JobRoleDO saveJobRole(String jobRoleName)
    {
        return null;
    }

    public JobRoleDO getJobRoleById(Long id)
    {
        return jobRoleRepo.findById(id).orElse(new JobRoleDO());
    }

    public List<JobRoleDO> getAllJobRoles()
    {
        return jobRoleRepo.findAll();
    }

    public JobRoleDO mapFromJobRoleRequest(String  jobRoleName)
    {
        return JobRoleDO.build(0L,jobRoleName);
    }
}
