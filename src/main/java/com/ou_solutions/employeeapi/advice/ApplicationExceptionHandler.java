package com.ou_solutions.employeeapi.advice;

import com.ou_solutions.employeeapi.exceptions.DepartmentNotFoundException;
import com.ou_solutions.employeeapi.exceptions.JobRoleNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInternalExceptions(MethodArgumentNotValidException ex)
    {
        Map<String,String> errorMap =  new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e  -> errorMap.put(e.getField(),e.getDefaultMessage()));
        return errorMap;
    }


    @ExceptionHandler(JobRoleNotFoundException.class)
    public Map<String,String> jobRoleNotFound(JobRoleNotFoundException ex)
    {
        Map<String,String> errorMap =  new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public Map<String,String> departmentNotFound(DepartmentNotFoundException ex)
    {
        Map<String,String> errorMap =  new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

}
