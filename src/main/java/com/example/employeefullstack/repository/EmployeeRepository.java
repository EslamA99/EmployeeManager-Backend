package com.example.employeefullstack.repository;

import com.example.employeefullstack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
