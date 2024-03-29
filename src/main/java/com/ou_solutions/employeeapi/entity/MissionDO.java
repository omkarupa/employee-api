package com.ou_solutions.employeeapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class MissionDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
