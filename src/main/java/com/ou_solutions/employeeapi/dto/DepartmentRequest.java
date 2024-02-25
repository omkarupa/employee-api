package com.ou_solutions.employeeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentRequest {

    @NotNull(message = "Department is mandatory")
    private String departmentName;
}
