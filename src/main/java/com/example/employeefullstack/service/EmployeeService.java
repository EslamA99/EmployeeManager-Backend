package com.example.employeefullstack.service;

import com.example.employeefullstack.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee getEmployeeById(Long id);
    Employee addEmployee(Employee employee);
    void deleteEmployee(Long id);
    List<Employee>getAll();
}
