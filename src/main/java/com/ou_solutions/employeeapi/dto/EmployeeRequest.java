package com.ou_solutions.employeeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeRequest {

    private String name;

    private String emailId;

    private String password;

    private String jobRole;

    private int salary;

    private String city;

    private String streetName;

    private String mobile;
}
