package com.example.springboot.maven.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Integer employeeId;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String contactNumber;
    private String address;
    private String dob;
    private String department;
    private String role;

}
