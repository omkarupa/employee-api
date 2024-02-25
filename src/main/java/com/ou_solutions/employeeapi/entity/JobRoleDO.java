package com.ou_solutions.employeeapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class JobRoleDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobRoleName;

    @OneToMany(mappedBy = "jobRoleDO")
    @JsonIgnore
    private List<EmployeeDO> employeeDOList;


}
