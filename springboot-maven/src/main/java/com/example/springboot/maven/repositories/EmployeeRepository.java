package com.example.springboot.maven.repositories;

import com.example.springboot.maven.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
