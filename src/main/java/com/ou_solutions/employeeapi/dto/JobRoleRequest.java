package com.ou_solutions.employeeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class JobRoleRequest {

    @NotNull(message = "Job Role is mandatory")
    private String jobRoleName;
}
