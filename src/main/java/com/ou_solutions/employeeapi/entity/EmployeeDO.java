package com.ou_solutions.employeeapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class EmployeeDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String emailId;

    private int salary;

    private String mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserDO userDO;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressDO addressDO;

    @ManyToOne
    @JoinColumn(name = "job_role_id")
    private JobRoleDO jobRoleDO;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentDO departmentDO;



}
