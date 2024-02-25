package com.ou_solutions.employeeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "build")
public class BearerToken {

    private String accessToken;
    private String tokenType;





}
