package com.ou_solutions.employeeapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeRequest {

    @NotNull(message = "Name is mandatory")
    private String name;
    @Email
    private String emailId;
    @NotNull(message = "Password is mandatory")
    private String password;
    @NotNull(message = "Job Role is mandatory")
    private String jobRole;
    @NotNull(message = "Salary is mandatory")
    private int salary;
    @NotNull(message = "City is mandatory")
    private String city;
    private String streetName;
    @NotNull(message = "Mobile Number is mandatory")
    private String mobile;
    @NotNull(message = "Department is mandatory")
    private String department;
}
