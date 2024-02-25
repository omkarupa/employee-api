package com.ou_solutions.employeeapi.advice;

import com.ou_solutions.employeeapi.exceptions.JobRoleNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(JobRoleNotFoundException.class)
    public Map<String,String> jobRoleNotFound(JobRoleNotFoundException ex)
    {
        Map<String,String> errorMap =  new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

}
